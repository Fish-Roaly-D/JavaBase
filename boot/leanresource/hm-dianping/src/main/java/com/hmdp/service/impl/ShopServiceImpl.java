package com.hmdp.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.hmdp.utils.CacheClient;
import com.hmdp.utils.RedisData;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.redislock.ILock;
import com.hmdp.utils.redislock.MyDefinedSimpleRedisLock;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.data.redis.domain.geo.GeoShape;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static com.hmdp.utils.RedisConstants.CACHE_NULL_TTL;
import static com.hmdp.utils.RedisConstants.CACHE_SHOP_KEY;
import static com.hmdp.utils.RedisConstants.CACHE_SHOP_TTL;
import static com.hmdp.utils.RedisConstants.LOCK_SHOP_KEY;
import static com.hmdp.utils.RedisConstants.LOCK_SHOP_TTL;
import static com.hmdp.utils.RedisConstants.PASS_THROUGH_VALUE;
import static com.hmdp.utils.RedisConstants.SHOP_GEO_KEY;

/**
 * <p>
 * 服务实现类
 * </p>
 * @author rolyfish
 */
@Service
@Slf4j
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    ReentrantLock lock = new ReentrantLock();

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CacheClient cacheClient;

    /**
     * 创建线程池
     */
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), r -> new Thread(r));

    @Override
    public Result queryById(Long id) {
        // 解决缓存穿透
        Shop shop = cacheClient
                .queryWithPassThrough(CACHE_SHOP_KEY, id, Shop.class, this::getById, CACHE_SHOP_TTL, TimeUnit.MINUTES);

        // 互斥锁解决缓存击穿
        // Shop shop = cacheClient
        //         .queryWithMutex(CACHE_SHOP_KEY, id, Shop.class, this::getById, CACHE_SHOP_TTL, TimeUnit.MINUTES);

        // 逻辑过期解决缓存击穿
        // Shop shop = cacheClient
        //         .queryWithLogicalExpire(CACHE_SHOP_KEY, id, Shop.class, this::getById, 20L, TimeUnit.SECONDS);


        // 自己实现的 解决缓存穿透
        // final Shop shop = this.queryWithPassThrough(id);

        // 互斥锁解决缓存击穿
        // final Shop shop = this.queryWithMutex(id);

        // 逻辑过期解决缓存击穿
        //final Shop shop = this.queryWithLogicalExpire(id);
        if (shop == null) {
            return Result.fail("店铺不存在！");
        }
        // 7.返回
        return Result.ok(shop);
    }

    private Shop queryWithPassThrough(Long id) {
        final String key = CACHE_SHOP_KEY + id;
        // 1 通过id查询缓存
        final String value = stringRedisTemplate.opsForValue().get(key);
        // 2.1 缓存命中且不为 "NULL" 返回数据
        if (StringUtils.isNotBlank(value) && !PASS_THROUGH_VALUE.equals(value)) {
            return JSONUtil.toBean(value, Shop.class);
        }
        // 2.2 命中 为空"NULL" 返回null 不再查询数据库
        if (PASS_THROUGH_VALUE.equals(value)) {
            return null;
        }
        // 3 查询数据库
        final Shop shop = this.getById(id);
        // 3.1 数据库未命中，空值写入缓存 返回null
        if (null == shop) {
            stringRedisTemplate.opsForValue().set(key, PASS_THROUGH_VALUE, CACHE_NULL_TTL, TimeUnit.MINUTES);
            return null;
        }
        // 3.2 数据库命中， 写入缓存 返回数据
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop), CACHE_NULL_TTL, TimeUnit.MINUTES);
        return shop;
    }

    /**
     * 逻辑过期解决缓存击穿
     *
     * @param id
     * @return
     */
    private Shop queryWithLogicalExpire(Long id) {
        final String key = CACHE_SHOP_KEY + id;
        // 1 通过id查询缓存
        final String value = stringRedisTemplate.opsForValue().get(key);
        // 2.1 缓存未命中
        if (StringUtils.isBlank(value)) {
            // 直接返回空
            return null;
        }
        // 2.2 命中 解析数据
        final RedisData redisData = JSONUtil.toBean(value, RedisData.class);
        final LocalDateTime expireTime = redisData.getExpireTime();
        final Shop shop = JSONUtil.toBean((JSONObject) redisData.getData(), Shop.class);
        // 2.2.1 未过期
        if (LocalDateTime.now().isBefore(expireTime)) {
            return shop;
        }
        MyDefinedSimpleRedisLock redisLock = new MyDefinedSimpleRedisLock(LOCK_SHOP_KEY + id, stringRedisTemplate);
        try {
            final boolean b = redisLock.tryLock(LOCK_SHOP_TTL + 100000L);
            // 2.2.2 过期  获取锁  开启新线程缓存重建
            if (b) {
                threadPoolExecutor.submit(() -> {
                    // 2.2.2.1 查询数据库
                    final Shop shop1 = getById(id);
                    // 2.2.2.2 构建RedisData
                    final RedisData redisData1 = new RedisData();
                    redisData1.setExpireTime(LocalDateTime.now().plusSeconds(CACHE_SHOP_TTL));
                    redisData1.setData(shop1);
                    stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + id, JSONUtil.toJsonStr(redisData1));
                });
            }
        } finally {
            redisLock.unlock();
        }
        return shop;
    }


    /**
     * 初始化热点key数据
     *
     * @param shopIds 店铺id
     */
    @Override
    public void initShop(Long... shopIds) {
        for (Long shopId : shopIds) {
            final String key = CACHE_SHOP_KEY + shopId;
            threadPoolExecutor.submit(() -> {
                // 2.2.2.1 查询数据库
                final Shop shop = getById(shopId);
                // 2.2.2.2 构建RedisData
                final RedisData redisData = new RedisData();
                redisData.setExpireTime(LocalDateTime.now().plusSeconds(CACHE_SHOP_TTL));
                redisData.setData(shop);
                stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(redisData));
            });
        }
    }


    /**
     * 互斥锁，阻塞线程，浪费资源
     *
     * @param id xx
     * @return
     */
    private Shop queryWithMutex(Long id) {
        final String key = CACHE_SHOP_KEY + id;
        // 1 通过id查询缓存
        final String value = stringRedisTemplate.opsForValue().get(key);
        // 2.1 缓存命中且不为 "NULL" 返回数据
        if (StringUtils.isNotBlank(value) && !PASS_THROUGH_VALUE.equals(value)) {
            return JSONUtil.toBean(value, Shop.class);
        }
        // 2.2 命中 为空"NULL" 返回null 不再查询数据库
        if (PASS_THROUGH_VALUE.equals(value)) {
            return null;
        }
        // 3 获取互斥锁
        final ILock redisLock = new MyDefinedSimpleRedisLock(LOCK_SHOP_KEY + id, stringRedisTemplate);
        try {
            final boolean b = redisLock.tryLock(1800);
            if (b) {
                // 缓存重建
                final Shop shop = this.getById(id);
                // 3.1 数据库未命中，空值写入缓存 返回null
                if (null == shop) {
                    stringRedisTemplate.opsForValue().set(key, PASS_THROUGH_VALUE, CACHE_NULL_TTL, TimeUnit.MINUTES);
                    return null;
                }
                stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop), CACHE_NULL_TTL, TimeUnit.MINUTES);
                return shop;
            } else {
                // 自旋重试
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return queryWithMutex(id);
            }
        } finally {
            redisLock.unlock();
        }
    }


    @Override
    @Transactional
    public Result update(Shop shop) {
        Long id = shop.getId();
        if (id == null) {
            return Result.fail("店铺id不能为空");
        }
        // 1.更新数据库
        updateById(shop);
        // 2.删除缓存
        stringRedisTemplate.delete(CACHE_SHOP_KEY + id);
        return Result.ok();
    }

    /**
     * @Description: 存在滚动分页查询问题，可以使用searchAndStore将距离放入sortedSet再进行滚动分页查询。但是前端参数确定了，不好改
     */
    @Override
    public Result queryShopByType(Integer typeId, Integer current, Double x, Double y) {
        // 1.判断是否需要根据坐标查询
        if (x == null || y == null) {
            // 不需要坐标查询，按数据库查询
            Page<Shop> page = query()
                    .eq("type_id", typeId)
                    .page(new Page<>(current, SystemConstants.DEFAULT_PAGE_SIZE));
            // 返回数据
            return Result.ok(page.getRecords());
        }

        // 2.计算分页参数
        int from = (current - 1) * SystemConstants.DEFAULT_PAGE_SIZE;
        int end = current * SystemConstants.DEFAULT_PAGE_SIZE;

        // 3.查询redis、按照距离排序、分页。结果：shopId、distance
        String key = SHOP_GEO_KEY + typeId;
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = stringRedisTemplate.opsForGeo() // GEOSEARCH key BYLONLAT x y BYRADIUS 10 WITHDISTANCE
                .search(
                        key,
                        GeoReference.fromCoordinate(x, y),
                        //new Distance(5, Metrics.KILOMETERS),
                        GeoShape.byRadius(new Distance(5, Metrics.KILOMETERS)),
                        RedisGeoCommands.GeoSearchCommandArgs.newGeoSearchArgs().includeDistance().limit(end)
                );
        // 4.解析出id
        if (results == null) {
            return Result.ok(Collections.emptyList());
        }
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> list = results.getContent();
        /*平均距离*/
        log.info(results.getAverageDistance().toString());
        if (list.size() <= from) {
            // 没有下一页了，结束
            return Result.ok(Collections.emptyList());
        }
        // 4.1.截取 from ~ end的部分
        final List<Long> ids = new ArrayList<>(list.size());
        final Map<String, Distance> distanceMap = new HashMap<>(list.size());
        list.stream().skip(from).forEach(result -> {
            // 4.2.获取店铺id
            String shopIdStr = result.getContent().getName();
            ids.add(Long.valueOf(shopIdStr));
            // 4.3.获取距离
            Distance distance = result.getDistance();
            distanceMap.put(shopIdStr, distance);
        });
        // 5.根据id查询Shop
        String idStr = StrUtil.join(",", ids);
        List<Shop> shops = query().in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list();
        for (Shop shop : shops) {
            shop.setDistance(distanceMap.get(shop.getId().toString()).getValue());
        }
        // 6.返回
        return Result.ok(shops);
    }
}

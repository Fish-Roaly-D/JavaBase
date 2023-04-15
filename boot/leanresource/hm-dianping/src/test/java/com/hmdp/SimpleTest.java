package com.hmdp;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.Shop;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IShopService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static com.hmdp.utils.RedisConstants.CACHE_NULL_TTL;
import static com.hmdp.utils.RedisConstants.CACHE_SHOP_KEY;
import static com.hmdp.utils.RedisConstants.PASS_THROUGH_VALUE;

/**
 * @author: rolyfish
 */
@Slf4j
@SpringBootTest
public class SimpleTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {

        stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + 123, PASS_THROUGH_VALUE, CACHE_NULL_TTL, TimeUnit.MINUTES);

    }

    @Autowired
    ISeckillVoucherService seckillVoucherService;

    @Test
    public void testUpdate() {

        final UpdateWrapper<SeckillVoucher> stock = new UpdateWrapper<SeckillVoucher>().set("stock", 999);

        final boolean update = seckillVoucherService.update(stock);


    }


    @Test
    void testExecutor() {

        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (runnable) -> new Thread(runnable));
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        final Future<String> submit1 = threadPoolExecutor.submit(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });
        final Future<String> submit2 = threadPoolExecutor.submit(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });
        final Future<String> submit3 = threadPoolExecutor.submit(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(submit1.get());
            System.out.println(submit2.get());
            System.out.println(submit3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {

        // xxx();
        //
        //
        // System.out.println(1111);

        final AtomicBoolean flag = new AtomicBoolean(true);

        flag.set(flag.get() && true);
        flag.set(flag.get() && true);
        flag.set(flag.get() && true);
        flag.set(flag.get() && true);

        System.out.println(flag.get());

    }

    public static void xxx() {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (runnable) -> new Thread(runnable));
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        final Future<String> submit1 = threadPoolExecutor.submit(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });
        final Future<String> submit2 = threadPoolExecutor.submit(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });
        final Future<String> submit3 = threadPoolExecutor.submit(() -> {
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(submit1.get());
            System.out.println(submit2.get());
            System.out.println(submit3.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        System.out.println(1);

    }

    @Test
    public void testLambdaQuery() {

        final List<SeckillVoucher> list = seckillVoucherService.list(new LambdaUpdateWrapper<>());
        final Integer count = Math.toIntExact(seckillVoucherService.lambdaQuery()
                .eq(SeckillVoucher::getVoucherId, 1)
                .eq(SeckillVoucher::getVoucherId, 1).count());

    }

    @Autowired
    IShopService shopService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void testGroup() {
        final List<Shop> shops = shopService.list();
        final Map<Long, List<Shop>> shopMap = shops.stream().collect(Collectors.groupingBy(Shop::getTypeId));
        final Set<Long> shopTypes = shopMap.keySet();
        for (Long shopType : shopTypes) {
            List<RedisGeoCommands.GeoLocation<String>> geoS = shopMap.get(shopType).stream().map(shopTemp -> new RedisGeoCommands.GeoLocation<>(shopTemp.getId().toString(), new Point(shopTemp.getX(), shopTemp.getY()))).collect(Collectors.toList());
            redisTemplate.opsForGeo().add("shop:geo:" + shopType, geoS);
        }
    }

    @Test
    public void testGeoSearch() {

        // 按经纬度查询
        final GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults1 = redisTemplate.opsForGeo().geoRadius("shop:geo:1", new Circle(new Point(120.149993, 30.334229), new Distance(10, Metrics.KILOMETERS)), RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().limit(10).sort(Sort.Direction.ASC).includeCoordinates().includeDistance());
        for (GeoResult<RedisGeoCommands.GeoLocation<String>> geoResult : geoResults1) {
            log.info(String.valueOf(geoResult));
        }
        log.info("\n");

        // 按member查询
        final GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults2 = redisTemplate.opsForGeo().radius("shop:geo:1", "1", new Distance(10, Metrics.KILOMETERS), RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().limit(10).sort(Sort.Direction.ASC).includeCoordinates().includeDistance());
        for (GeoResult<RedisGeoCommands.GeoLocation<String>> geoResult : geoResults2) {
            log.info(String.valueOf(geoResult));
        }
        log.info("\n");

        final GeoResults<RedisGeoCommands.GeoLocation<String>> search1 = redisTemplate.opsForGeo().search("shop:geo:1", GeoReference.fromMember("1"), new Distance(10, Metrics.KILOMETERS), RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().limit(10).sort(Sort.Direction.ASC).includeCoordinates().includeDistance());
        for (GeoResult<RedisGeoCommands.GeoLocation<String>> geoResult : search1) {
            log.info(String.valueOf(geoResult));
        }
        log.info("\n");


        final GeoResults<RedisGeoCommands.GeoLocation<String>> search2 = redisTemplate.opsForGeo().search("shop:geo:1", GeoReference.fromCircle(new Circle(new Point(120.149993, 30.334229), new Distance(10, Metrics.KILOMETERS))), new Distance(10, Metrics.KILOMETERS), RedisGeoCommands.GeoRadiusCommandArgs.newGeoSearchArgs().limit(10).sort(Sort.Direction.ASC).includeCoordinates().includeDistance());
        for (GeoResult<RedisGeoCommands.GeoLocation<String>> geoResult : search2) {
            log.info(String.valueOf(geoResult));
        }
        log.info("\n");
    }

}


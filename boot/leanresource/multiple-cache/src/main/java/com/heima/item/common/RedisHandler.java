package com.heima.item.common;

import cn.hutool.json.JSONUtil;
import com.heima.item.pojo.Item;
import com.heima.item.pojo.ItemStock;
import com.heima.item.service.IItemService;
import com.heima.item.service.IItemStockService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: rolyfish
 * @Description 缓存预热
 */
@Component
public class RedisHandler implements InitializingBean {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    IItemService itemService;

    @Autowired
    IItemStockService iItemStockService;

    private final ThreadPoolExecutor threadpoolexecutor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    });

    private final String ITEM_KEY = "item:id:";
    private final String ITEM_STOCK__KEY = "item:stock:id:";

    @Override
    public void afterPropertiesSet() {
        final List<Item> itemList = itemService.list();
        final List<ItemStock> itemStockList = iItemStockService.list();
        threadpoolexecutor.execute(() -> {
            for (Item item : itemList) {
                stringRedisTemplate.opsForValue().set(ITEM_KEY + item.getId(), JSONUtil.toJsonStr(item));
            }
        });
        threadpoolexecutor.execute(() -> {
            for (ItemStock itemStock : itemStockList) {
                stringRedisTemplate.opsForValue().set(ITEM_STOCK__KEY + itemStock.getId(), JSONUtil.toJsonStr(itemStock));
            }
        });
    }

    public void saveItem(Item item) {
        String json = JSONUtil.toJsonStr(item);
        stringRedisTemplate.opsForValue().set("item:id:" + item.getId(), json);
    }

    public void deleteItemById(Long id) {
        stringRedisTemplate.delete("item:id:" + id);
    }
}

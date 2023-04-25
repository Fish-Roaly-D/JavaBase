package com.roily.jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.resps.ScanResult;

import java.util.List;
import java.util.Set;

/**
 * @author: rolyfish
 */
public class JedisTest {

    private Jedis jedis;
    final Logger logger = LoggerFactory.getLogger(getClass());

    final static int STR_MAX_LEN = 10 * 1024;
    final static int HASH_MAX_LEN = 500/*3*/;

    @BeforeEach
    private void init() {
        jedis = new Jedis("10.211.55.4", 6380);
        jedis.auth("123123");
    }

    @Test
    public void test() {
        final Set<String> keys = jedis.keys("*");
        logger.info("keys * : {}", keys);
    }


    @Test
    void testScan() {
        int maxLen = 0;
        long len = 0;
        String cursor = "0";
        do {
            // 扫描并获取一部分key
            ScanResult<String> result = jedis.scan(cursor);
            // 记录cursor
            cursor = result.getCursor();
            List<String> list = result.getResult();
            if (list == null || list.isEmpty()) {
                break;
            }
            // 遍历
            for (String key : list) {
                // 判断key的类型
                String type = jedis.type(key);
                switch (type) {
                    case "string":
                        len = jedis.strlen(key);
                        maxLen = STR_MAX_LEN;
                        break;
                    case "hash":
                        len = jedis.hlen(key);
                        maxLen = HASH_MAX_LEN;
                        break;
                    case "list":
                        len = jedis.llen(key);
                        maxLen = HASH_MAX_LEN;
                        break;
                    case "set":
                        len = jedis.scard(key);
                        maxLen = HASH_MAX_LEN;
                        break;
                    case "zset":
                        len = jedis.zcard(key);
                        maxLen = HASH_MAX_LEN;
                        break;
                    default:
                        break;
                }
                if (len >= maxLen) {
                    logger.info("Found big key : {}, type:{} , length or size: {}", key, type, len);
                }
            }
        } while (!cursor.equals("0"));
    }

    @AfterEach
    private void resolveJedis() {
        jedis.close();
    }
}


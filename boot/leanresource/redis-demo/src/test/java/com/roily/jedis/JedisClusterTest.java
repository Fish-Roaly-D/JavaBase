package com.roily.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.ClusterSlotHashUtil;
import redis.clients.jedis.Connection;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: rolyfish
 */
public class JedisClusterTest {

    private JedisCluster jedisCluster;
    final Logger logger = LoggerFactory.getLogger(getClass());

    @BeforeEach
    public void init() {
        // 配置连接池
        final GenericObjectPoolConfig<Connection> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(8);
        config.setMaxIdle(8);
        config.setMinIdle(0);
        config.setMaxWaitMillis(1000);
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("10.211.55.4", 7001));
        nodes.add(new HostAndPort("10.211.55.4", 7002));
        nodes.add(new HostAndPort("10.211.55.4", 7003));
        nodes.add(new HostAndPort("10.211.55.4", 8001));
        nodes.add(new HostAndPort("10.211.55.4", 8002));
        nodes.add(new HostAndPort("10.211.55.4", 8003));
        jedisCluster = new JedisCluster(nodes, config);
    }

    @Test
    void testMSet2() {
        Map<String, String> map = new HashMap<>(3);
        map.put("name", "Jack");
        map.put("age", "21");
        map.put("sex", "Male");
        // 对Map数据进行分组。根据相同的slot放在一个分组
        // key就是slot，value就是一个组
        Map<Integer, List<Map.Entry<String, String>>> result = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        entry -> ClusterSlotHashUtil.calculateSlot(entry.getKey()))
                );
        // 串行的去执行mset的逻辑
        for (List<Map.Entry<String, String>> list : result.values()) {
            String[] arr = new String[list.size() * 2];
            int j = 0;
            for (int i = 0; i < list.size(); i++) {
                j = i << 2;
                Map.Entry<String, String> e = list.get(i);
                arr[j] = e.getKey();
                arr[j + 1] = e.getValue();
            }
            jedisCluster.mset(arr);
        }
    }

    @Test
    public void test() {
        String[] kvBf = new String[1000];
        for (int i = 0; i < 100_0; i += 2) {
            // 0-1998
            int keyIndex = i % 2000;
            int valueIndex = keyIndex + 1;
            kvBf[keyIndex] = "mset:key_" + i / 2;
            kvBf[valueIndex] = "mset_value_" + i / 2;
            if (valueIndex == 999) {
                jedisCluster.mset(kvBf);
            }
        }
    }

    @AfterEach
    public void releaseConn() {
        if (null != jedisCluster) {
            jedisCluster.close();
        }
    }
}

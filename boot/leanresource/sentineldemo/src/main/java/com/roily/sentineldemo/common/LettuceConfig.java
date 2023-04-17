package com.roily.sentineldemo.common;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: rolyfish
 */
@Configuration
public class LettuceConfig {

    /**
     * 配置 lettuc读写策略
     * - MASTER：从主节点读取
     * - MASTER_PREFERRED：优先从master节点读取，master不可用才读取replica
     * - REPLICA：从slave（replica）节点读取
     * - REPLICA _PREFERRED：优先从slave（replica）节点读取，==所有的==slave都不可用才读取master
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer clientConfigurationBuilderCustomizer() {
        return clientConfigurationBuilder -> clientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);
    }

}

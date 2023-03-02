package com.roly.dubbo_zookeeper_provider.service;

import com.roly.cloud.service.ServiceProvider;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author: rolyfish
 */
@DubboService
@Slf4j
@Data
public class ProviderService implements ServiceProvider {
    @Override
    public String msg() {
        log.info("服务提供方");
        return "服务提供方返回数据";
    }
}

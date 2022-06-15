package com.roily.designpatterns.dpmain.bridge;

import lombok.Getter;
import lombok.Setter;

/**
 * @className：AbstractBridge
 * @author: rolyfish
 * @description: 抽象桥接器
 * @dte: 2022/6/15 19:24
 */
@Getter
@Setter
public abstract class AbstractBridge {
    /**
     * 在抽象层将ISource组合进来，并提供getter和setter方法
     */
    private ISource source;

    public void method(){
        source.method1();
    }
}

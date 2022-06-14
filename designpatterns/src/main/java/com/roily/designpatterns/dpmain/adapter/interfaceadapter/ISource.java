package com.roily.designpatterns.dpmain.adapter.interfaceadapter;

/**
 * @className：ISource
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 00:27
 */
public interface ISource {
    /**
     * 方法一，Adapter1需要 而 Adapter2不需要
     */
    void method01();

    /**
     * 方法二，Adapter2需要 而 Adapter1不需要
     */
    void method02();
}

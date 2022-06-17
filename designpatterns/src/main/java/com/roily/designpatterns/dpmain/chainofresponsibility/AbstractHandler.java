package com.roily.designpatterns.dpmain.chainofresponsibility;

import lombok.Data;

/**
 * @className：AbstractHandler
 * @author: rolyfish
 * @description: 抽象夫类
 * @dte: 2022/6/18 00:07
 */
@Data
public abstract class AbstractHandler {
    /**
     * 将对象组合进来
     */
    private Handler handler;
}

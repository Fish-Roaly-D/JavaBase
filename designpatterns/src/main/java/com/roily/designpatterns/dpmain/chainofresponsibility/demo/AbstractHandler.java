package com.roily.designpatterns.dpmain.chainofresponsibility.demo;

import lombok.Data;

/**
 * @className：AbstractHandler
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/18 00:29
 */
@Data
public abstract class AbstractHandler {

    private Handler handler;

}

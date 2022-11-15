package com.roily.designpatterns.dpmain.chainofresponsibility;

import org.junit.Test;

/**
 * @className：ChainOfResibilityTest
 * @author: rolyfish
 * @description: 测试
 * @dte: 2022/6/18 00:10
 */
public class ChainOfResponsibilityTest {

    @Test
    public void test() {

        HandlerImpl handler1 = new HandlerImpl("1");
        HandlerImpl handler2 = new HandlerImpl("2");
        HandlerImpl handler3 = new HandlerImpl("3");
        HandlerImpl handler4 = new HandlerImpl("4");

        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler3.setHandler(handler4);
        handler1.operate();
    }

}

package com.roily.designpatterns.dpmain.bridge;

import org.junit.Test;

/**
 * @className：BridgeTest
 * @author: rolyfish
 * @description: 桥接模式测试
 * @dte: 2022/6/15 19:28
 */
public class BridgeTest {

    @Test
    public void test(){
        AbstractBridge myBridge = new MyBridge();
        //执行Source1的方法
        myBridge.setSource(new Source1());
        myBridge.method();
        //执行Source2的方法
        myBridge.setSource(new Source2());
        myBridge.method();
    }


}

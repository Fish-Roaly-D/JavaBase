package com.roily.designpatterns.dpmain.proxy.jdkproxy.jdkcannotproxyabsclass;

import com.roily.designpatterns.dpmain.proxy.jdkproxy.CommonInvocationHandler;
import org.junit.Test;

/**
 * @className：CanNotProxyAbsClass
 * @author: rolyfish
 * @description: 测试jdk动态代理不能代理抽象类
 * @dte: 2022/6/15 18:40
 */
public class CanNotProxyAbsClass {
    /**
     * 测试不能代理继承抽象类的类
     */
    @Test
    public void test3(){
        CommonInvocationHandler commonInvocationHandler = new CommonInvocationHandler();
        commonInvocationHandler.setObject(new AbsL());
        Absclass proxy = (Absclass)commonInvocationHandler.getProxy();
        proxy.aaa();
    }

    /**
     * 测试不能代理普通类
     */
    @Test
    public void test4(){
        CommonInvocationHandler commonInvocationHandler = new CommonInvocationHandler();
        commonInvocationHandler.setObject(new AbsL2());
        AbsL2 proxy = (AbsL2)commonInvocationHandler.getProxy();
        proxy.aaa();
    }
}

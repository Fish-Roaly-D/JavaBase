package com.roily.designpatterns.dpmain.proxy.common;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @version 1.0.0
 * @Description JDK动态代理通用写法
 * @ClassName CommonInvocationHandler.java
 * @author: RoilyFish
 * @date: 2022/6/9 0:07
 */
@Data
public class CommonInvocationHandler implements InvocationHandler {

    //代理所有对象
    private Object object;

    public Object getProxy() {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        prevWork();
        Object invoke = method.invoke(object, args);
        nextWork();
        return invoke;
    }

    private void prevWork() {
        System.out.println(object.getClass().getName() + "类的实例被代理");
        System.out.println("该类实现的接口列表为：" + Arrays.toString(object.getClass().getInterfaces()));
    }

    private void nextWork() {
        System.out.println(object.getClass().getName() + "执行完毕");
    }

}

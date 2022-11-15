package com.roily.designpatterns.dpmain.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @version 1.0.0
 * @Description
 * @ClassName MyMethodInterceptor.java
 * @author: RoilyFish
 * @date: 2022/6/9 23:52
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     * 拦截方法
     *
     * @param o           the enhanced obj  已被增强对象
     * @param method      intercepted Method 被拦截方法
     * @param objects     参数列表，基本类型会替换为包装类型
     * @param methodProxy 代理方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("被代理方法名称:" + method.getName());
        System.out.println("=====开始增强=====");
        final Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("=====增强结束=====");
        return o1;
    }
}

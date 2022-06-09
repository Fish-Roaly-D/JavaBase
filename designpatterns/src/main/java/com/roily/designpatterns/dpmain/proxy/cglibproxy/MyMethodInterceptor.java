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

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("开始增强");

        //method.invoke(o, objects);

        methodProxy.invokeSuper(o, objects);
        System.out.println("增强结束");
        return null;
    }

}

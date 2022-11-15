package com.roily.designpatterns.dpmain.proxy.jdkproxy.jdk01;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @version 1.0.0
 * @Description 买房子处理程序
 * @ClassName SellHouseHandler.java
 * @author: RoilyFish
 * @date: 2022/6/8 23:41
 */
@Data
public class SellHouseHandler implements InvocationHandler {

    /**
     * 代理SellHouse这一类的真实角色
     */
    private SellHouse sellHouse;

    /**
     * 生成代理对象
     *
     * 参数说明：
     * - 真实对象类加载器
     * - 真实对象接口列表
     * - 实现InvocationHandler接口的实例，也就是this
     */
    public Object getProxy() {
       return Proxy.newProxyInstance(
                sellHouse.getClass().getClassLoader(),
                sellHouse.getClass().getInterfaces(),
                this);
    }

    /**
     * 实现invocationHandler接口必须重写的方法
     *
     * @param proxy  代理角色
     * @param method 真实角色执行方法的包装（可以通过反射获取）
     * @param args   真实对象执行方法的参数列表
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(Arrays.toString(proxy.getClass().getInterfaces()));
        prevWork();
        Object invoke = method.invoke(sellHouse, args);
        nextWork();
        return invoke;
    }

    private void prevWork(){
        System.out.println("挂牌");
        System.out.println("联系客户");
        System.out.println("签合同");
    }

    private void nextWork(){
        System.out.println("维护");
    }

}

package com.roily.designpatterns.dpmain.proxy.staticproxy;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Date: 2022/08/29/17:02
 * @Description:
 */
@Data
public class SellGoodsInvocationHandler implements InvocationHandler {

    //代理谁？
    private SellGoods sellGoods;

    /**
     * 生成代理对象
     */
    public Object newProxyInstance() {

        return Proxy.newProxyInstance(sellGoods.getClass().getClassLoader(), sellGoods.getClass().getInterfaces(), this);

    }

    /**
     * 代理对象对真实对象增强
     *
     * @param proxy  代理对象
     * @param method 被代理对象method实例，内部包含被代理对象方法信息
     * @param args   method参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理对象实现接口
        System.out.println("代理对象实现接口:");
        for (Class<?> anInterface : proxy.getClass().getInterfaces()) {
            System.out.println(anInterface.getName());
        }
        prev();
        //invoke 第一个参数：被代理对象实例，第二个参数，被代理对象方法参数
        Object returnVal = method.invoke(sellGoods,args);
        last();
        return returnVal;
    }

    private void prev() {
        System.out.println(sellGoods.getClass().getName() + "类被代理，前置方法");
    }

    private void last() {
        System.out.println(sellGoods.getClass().getName() + "类被代理，后置方法");
    }


    @Test
    public void test(){
        final SellGoodsInvocationHandler sellGoodsInvocationHandler = new SellGoodsInvocationHandler();
        sellGoodsInvocationHandler.setSellGoods(new GoodsOwner());
        final SellGoods sellGoodsProxy = (SellGoods)sellGoodsInvocationHandler.newProxyInstance();
        sellGoodsProxy.doSell();
    }
}

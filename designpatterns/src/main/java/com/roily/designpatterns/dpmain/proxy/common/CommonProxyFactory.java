package com.roily.designpatterns.dpmain.proxy.common;

/**
 * @version 1.0.0
 * @Description
 * @ClassName CommonProxyFactory.java
 * @author: RoilyFish
 * @date: 2022/6/9 0:33
 */
public class CommonProxyFactory {

    //必须在构造器实例化
    private final Class<?> classInterface;

    public CommonProxyFactory(Class<?> classInterface) {
        this.classInterface = classInterface;
    }


    public Object newInstance(){
        return null;
    }

}

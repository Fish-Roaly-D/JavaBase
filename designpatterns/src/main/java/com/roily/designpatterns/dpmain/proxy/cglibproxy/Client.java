package com.roily.designpatterns.dpmain.proxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Client.java
 * @author: RoilyFish
 * @date: 2022/6/10 0:25
 */
public class Client {

    public static void main(String[] args) {
        //在指定目录下生成动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\java\\java_workapace2");

        CgLibProxy cgLibProxy = new CgLibProxy();

        cgLibProxy.setObject(Obj.class);
        //这里的creat方法就是正式创建代理类
        Obj proxy = (Obj)cgLibProxy.getProxy();
        //调用代理类的final方法
        proxy.doSomeThing();
        //调用代理类的非final方法
        proxy.doOtherThing();
    }
}

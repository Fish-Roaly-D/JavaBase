package com.roily.designpatterns.dpmain.proxy.cglibproxy;

import lombok.Data;
import net.sf.cglib.proxy.Enhancer;

@Data
public class CgLibProxy {

    private Class<? extends Object> object;

    public Object getProxy() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件,很明显使用反射实现
        enhancer.setSuperclass(object);
        //设置借助哪个拦截器实现（也就是做哪些增强）
        enhancer.setCallback(new MyMethodInterceptor());
        //这里的creat方法就是正式创建代理类
        return enhancer.create();
    }


}
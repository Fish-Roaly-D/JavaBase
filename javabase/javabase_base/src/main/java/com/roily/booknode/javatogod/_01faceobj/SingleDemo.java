package com.roily.booknode.javatogod._01faceobj;


import java.io.Serializable;

/**
 * @classname：SingleDemo
 * @author: rolyfish
 * @description: 单例对象
 * @date: 2022/8/26 01:26
 */
public class SingleDemo implements Serializable {
    private static final long serialVersionUID = -6489201409969990006L;

    private static SingleDemo singleDemo;
    //构造方法私有化
    private SingleDemo() {
    }
    public static SingleDemo getInstance() {
        if (null == singleDemo){
            singleDemo = new SingleDemo();
        }
        return singleDemo;
    }
}

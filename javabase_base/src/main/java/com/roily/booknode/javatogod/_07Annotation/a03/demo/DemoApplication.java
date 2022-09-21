package com.roily.booknode.javatogod._07Annotation.a03.demo;

import java.io.FileNotFoundException;

/**
 * @Date: 2022/08/31/13:48
 * @Description:
 */
public class DemoApplication {


    /**
     * 启动类
     */
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        Class.forName("com.roily.booknode.javatogod._07Annotation.a03.demo.BeanFactory");

        System.out.println(BeanFactory.objList());

        System.out.println("容器中的bean实例都是单例的:" + BeanFactory.getObjByName("UserDao") == BeanFactory.getObjByName("UserDao"));
    }


}

package com.roily.usefultools.classutils;

import org.junit.Test;
import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @className：ClassUtilsTest
 * @author: rolyfish
 * @description: Springframework提供的ClassUtils
 * @dte: 2022/6/23 23:19
 */
public class ClassUtilsTest {

    /**
     * 获取一个对象的接口列表
     */
    @Test
    public void getAllInterfaces() {
        List<Object> list = new ArrayList<>();

        Arrays.asList(ClassUtils.getAllInterfaces(list)).forEach(System.out::println);

        //得到Class就可以得到一切，只不过我们不确定给的对象是否实现了接口，而ClassUtils没有这个问题
        System.out.println(Arrays.toString(list.getClass().getInterfaces()));
    }

    /**
     * 获取包名
     */
    @Test
    public void getPackageName() {
        List<Object> list = new ArrayList<>();
        //获取包名
        System.out.println(ClassUtils.getPackageName(list.getClass()));
        //用package对象也可以
        System.out.println(list.getClass().getPackage().getName());
    }


    /**
     * 判断一个类是否是内部类
     */
    @Test
    public void isInnerClass() {
        List<Object> list = new ArrayList<>();
        System.out.println(ClassUtils.isInnerClass(list.getClass()));

        HashMap<Object, Object> map = new HashMap<>(10);
        System.out.println(ClassUtils.isInnerClass(map.keySet().getClass()));
    }

    /**
     * 判断一个类是否是代理类
     */
    @Test
    public void isProxy() {
        List<Object> list = new ArrayList<>();
        System.out.println(ClassUtils.isCglibProxy(list.getClass()));

    }



}

package com.roily.designpatterns.dpmain.strategy.strategydemo;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @className：DemoTest
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 01:24
 */
public class DemoTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Context context = new Context();
        Person personAdd = new Person("yyc5", 25, new Date(System.currentTimeMillis()));
        Person personModify = new Person("yyc2", 252123, new Date(System.currentTimeMillis()));
        Person personSearch = new Person("yyc3", 23, new Date(System.currentTimeMillis()));

        context.doStrategy("22061601", personAdd);

        context.doStrategy("22061602", personAdd);

        context.doStrategy("22061603", personModify);

        context.doStrategy("22061604", personSearch);



    }

    @Test
    public void test() throws ClassNotFoundException {

        Class<?> aClass = Class.forName("com.roily.designpatterns.dpmain.strategy.strategydemo."+"AddAction");
    }

}

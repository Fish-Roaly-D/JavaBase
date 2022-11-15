package com.roily.designpatterns.dpmain.decorator.transparentdecorator;

import lombok.val;
import org.junit.Test;

/**
 * @className：Ttest
 * @author: rolyfish
 * @description: 测试
 * @dte: 2022/6/15 02:16
 */
public class Testy {

    @Test
    public void test01(){
        //具体构件
        IComponent component01 = new Component01();
        //视为IComponent
        IComponent decorator1 = new Decorator1(component01);
        decorator1.method();
    }

    /**
     * 此装饰器可以装饰实现IComponent接口的所有构件
     */
    @Test
    public void test02(){
        //具体构件
        IComponent component02 = new Component02();
        //视为IComponent
        IComponent decorator1 = new Decorator1(component02);
        decorator1.method();
    }
    
    /**
     * 因为装饰器也实现了抽象构件接口，所以装饰器也可以装饰装饰器，达到复用目的
     */
    @Test
    public void test03(){
        //具体构件
        IComponent component02 = new Component02();
        //视为IComponent
        IComponent decorator1 = new Decorator1(component02);
        decorator1.method();
        System.out.println("<+++++++++++++++++++++>");
        IComponent decorator2 = new Decorator2(decorator1);
        decorator2.method();
    }

}

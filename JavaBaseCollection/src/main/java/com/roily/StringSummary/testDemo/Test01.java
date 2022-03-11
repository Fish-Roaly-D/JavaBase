package com.roily.StringSummary.testDemo;

import org.junit.Test;

/**
 * descripte:此实例验证被final修饰不是String类不可变的主要原因
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
public class Test01 {

    @Test
    public void test01(){

        FatherEntity fatherEntity = new FatherEntity(new StringBuffer("123"));

        System.out.println(fatherEntity.toString());

        fatherEntity.stringBuffer.append("第一次Append");

        System.out.println(fatherEntity.toString());


    }

    @Test
    public void test02(){

        SonEntity sonEntity = new SonEntity(new StringBuffer("123"));

        System.out.println(sonEntity.toString());

    }
}

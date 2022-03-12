package com.roily.StringSummary.testDemo;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * descripte:此实例验证被final修饰不是String类不可变的主要原因
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
public class Test01 {



    @Test
    public void test1(){

        FatherEntity fatherEntity = new FatherEntity(new StringBuffer("123"));

        System.out.println(fatherEntity.stringBuffer.hashCode());

        System.out.println("1.=>"+fatherEntity.toString());
        System.out.println("修改");
        fatherEntity.modifySb("abc");
        System.out.println("2.=>"+fatherEntity.toString());

        System.out.println(fatherEntity.stringBuffer.hashCode());

    }

    @Test
    public void test2(){

        FatherEntity fatherEntity = new FatherEntity(new StringBuffer("123"));
        System.out.println(fatherEntity.toString());
        System.out.println(fatherEntity.stringBuffer.hashCode());
        try {
            Field sbField = fatherEntity.getClass().getDeclaredField("stringBuffer");
            sbField.setAccessible(true);
            StringBuffer stringBuffer = new StringBuffer("aaaaa");

            sbField.set(fatherEntity,stringBuffer);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(fatherEntity.toString());
        System.out.println(fatherEntity.stringBuffer.hashCode());
    }

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

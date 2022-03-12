package com.roily.StringSummary.testDemo2;

import org.junit.Test;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/12
 */
public class test {

    @Test
    public void test01() {

        String str1 = "abc";
        System.out.println("str修改前哈希值==>"+str1.hashCode()+"|||"+str1);
        str1 = "123";
        System.out.println("str修改后哈希值==>"+str1.hashCode()+"|||"+str1);
    }


    @Test
    public void test02(){

        String str = "abc";

        modifyStr(str);

        System.out.println("str结果");
        System.out.println("str值=>"+str+"||||"+"str哈希值=>"+str.hashCode());

    }

    public void modifyStr(String str){

        str = "123";
        System.out.println("在方法内修改str");
        System.out.println("str值=>"+str+"||||"+"str哈希值=>"+str.hashCode());
    }

    @Test
    public void test03(){

        StringBuilder stringBuilder = new StringBuilder("abc");

        modifySb(stringBuilder);

        System.out.println("str结果");
        System.out.println("str值=>"+stringBuilder.toString()+"||||"+"str哈希值=>"+stringBuilder.hashCode());

    }

    public void modifySb(StringBuilder sb){

        sb.append("123");
        System.out.println("在方法内修改sb");
        System.out.println("str值=>"+sb.toString()+"||||"+"str哈希值=>"+sb.hashCode());
    }


}

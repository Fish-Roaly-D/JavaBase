package com.roily.aboutFinal;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/**
 * @version 1.0.0
 * @Description finally 代码块何时不会被执行
 * @ClassName Demo01.java
 * @author: RoilyFish
 * @date: 2022/4/1 0:12
 */
public class Demo01 {


    @Test
    public void test1() {
        System.out.println("执行业务");
        if (true) {
            //直接return 通不过编译检查的
            return;
        }
        try {
            System.out.println("dosomething");
        } finally {
            System.out.println("执行finally");
        }
    }

    @Test
    public void test2() {
        System.out.println("执行业务");
        //结束虚拟机
        System.exit(0);
        try {
            System.out.println("dosomething");
        } finally {
            System.out.println("执行finally");
        }
    }

    public Integer add() {
        Integer i = 10;
        try {
            return i = i + 100;
        } finally {
            System.out.println("i的值为=>" + i);
        }
    }

    @Test
    public void test3() {
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.add());
    }

    public String str() {

        try {
            System.out.println("try执行");
            return "try return";
        } finally {
            System.out.println("finally执行");
            return "finally return";
        }
    }

    @Test
    public void test() {

        Demo01 demo01 = new Demo01();
        System.out.println(demo01.str());

    }


    public int xxx(Integer i) {

        try {
            System.out.println("try  原结果=>"+i);
            return i;
        } finally {
            if (i >= 16) {
                i = i & ((1 << 4) - 1);
                System.out.println("finally 修改后=>"+i);
            }
        }
    }
    public int xxxxxx(int i) {

        try {
            System.out.println("try  原结果=>"+i);
            return i;
        } finally {
            if (i >= 16) {
                i = i & ((1 << 4) - 1);
                System.out.println("finally 修改后=>"+i);
            }
        }
    }

    @Test
    public void test5(){
        Demo01 demo01 = new Demo01();
        System.out.println("最终结果=>"+demo01.xxxxxx(20));

    }

    @Data
    @AllArgsConstructor
    class Person{
        int age;
        String name;
    }
    public Person xxx2(Person p) {

        try {
            System.out.println("try  原结果=>"+p);
            return p;
        } finally {
            if (p.getName().equals("abc")) {
                p.setName("123");
                System.out.println("finally 修改后=>"+p);
            }
        }
    }

    @Test
    public void test52(){
        Demo01 demo01 = new Demo01();
        System.out.println("最终结果=>"+demo01.xxx2(new Person(23,"abc")));

    }

}

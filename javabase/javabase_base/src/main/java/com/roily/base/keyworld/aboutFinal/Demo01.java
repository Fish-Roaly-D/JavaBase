package com.roily.base.keyworld.aboutFinal;

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


    /**
     * 在try  finally代码块之前return不会执行finally代码块。
     */
    @Test
    public void testReturnBeforeTry() {
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

    /**
     * 在try finally之前结束虚拟机，不会执行finally代码块
     */
    @Test
    public void testReturnBeforeExit() {
        System.out.println("执行业务");
        //结束虚拟机
        System.exit(0);
        try {
            System.out.println("dosomething");
        } finally {
            System.out.println("执行finally");
        }
    }
/************关于接本数据类型，return的返回值决定于，表达式的值**************/
    /**
     * 后加
     *
     * @return
     */
    public Integer addNext() {
        Integer i = 10;
        try {
            return i++;
        } finally {
            System.out.println("i的值为=>" + i);
        }
    }

    /**
     * 后加
     *
     * @return
     */
    public Integer addPrev() {
        Integer i = 10;
        try {
            return ++i;
        } finally {
            System.out.println("i的值为=>" + ++i);
        }
    }

    /**
     * 表达式
     *
     * @return
     */
    public Integer addExpression() {
        Integer i = 10;
        try {
            return i + 1;
        } finally {
            System.out.println("i的值为=>" + i);
        }
    }

    @Test
    public void test3() {
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.addNext());
        System.out.println(demo01.addPrev());
        System.out.println(demo01.addExpression());
    }

    /***************finally代码块的执行在return之前***********/

    StringBuffer modifyStringBuffer(StringBuffer sb) {
        try {
            return sb.append("return");
        } finally {
            sb.append("finally");
        }
    }

    @Test
    public void testFinallyBeforeReturn() {
        System.out.println(modifyStringBuffer(new StringBuffer("xxx")));
    }

    /************在final代码块中return，会覆盖之前的return****************/
    public String returnInFinally() {
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
        System.out.println(demo01.returnInFinally());
    }


    /*****对于基本数据类型，只有值的概念，return的时候会记住对应值，后续无论在finally中如何修改都不会修改return返回的结果*******/
    public int finallyModifyInt(int i) {

        try {
            System.out.println("try  原结果=>" + i);
            return i;
        } finally {
            if (i >= 16) {
                i = i & ((1 << 4) - 1);
                System.out.println("finally 修改后=>" + i);
            }
        }
    }

    @Test
    public void test5() {
        Demo01 demo01 = new Demo01();
        System.out.println("最终结果=>" + demo01.finallyModifyInt(20));
    }

    /******对于不可变的数据类型，修改值就直接修改了引用，而return会记住需要return的引用，所以说不会影响**/

    /****对于可变的引用类型，由于他们1⃣️属于引用类型2⃣️提供了修改当前对象的Api。所以在finally中对对象的修改，会影响return的结果****/
    @Data
    @AllArgsConstructor
    class Person {
        Integer age;
        String name;
    }

    public Person modifyPerson(Person p) {

        try {
            System.out.println("try  原结果=>" + p);
            return p;
        } finally {
            if (p.getName().equals("abc")) {
                p.setName("123");
                System.out.println("finally 修改后=>" + p);
            }
        }
    }

    @Test
    public void test52() {
        Demo01 demo01 = new Demo01();
        System.out.println("最终结果=>" + demo01.modifyPerson(new Person(23, "abc")));

    }

}

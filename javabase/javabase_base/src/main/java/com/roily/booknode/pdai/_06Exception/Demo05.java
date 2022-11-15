package com.roily.booknode.pdai._06Exception;

import org.junit.Test;

/**
 * @classname：Demo05
 * @author: rolyfish
 * @description: try catch finally执行顺序
 * @date: 2022/11/2 22:25
 */
public class Demo05 {

    static StringBuilder m1() {
        boolean f = true;
        final StringBuilder sb = new StringBuilder("<init>、");
        try {
            sb.append("<tryprev>、");
            int i = 1 / 0;
            sb.append("<trylast>、");
            return sb.append("<tryreturn>、");
        } finally {
            sb.append("<finally>");
        }
        //通过不了编译，因为要么return 要么异常向上抛出
        //sb.append("<last>");
    }

    static StringBuilder m2() {
        boolean f = true;
        final StringBuilder sb = new StringBuilder("<init>、");
        try {
            sb.append("<tryprev>、");
            int i = 1 / 0;
            sb.append("<trylast>、");
            return sb.append("<tryreturn>、");
        } finally {
            sb.append("<finally>");
            //此刻若在finally代码块中进行return，则不会抛出异常，但这么写是建议的且编译器会有警告。结果：`<init>、<tryprev>、<finally><tryreturn>、`
            return sb.append("<tryreturn>、");
        }
        //通过不了编译，因为要么return 要么异常向上抛出
        //sb.append("<last>");
    }

    static StringBuilder m3() {
        boolean f = true;
        final StringBuilder sb = new StringBuilder("<init>、");
        try {
            sb.append("<tryprev>、");
            int i = 1 / 0;
            sb.append("<trylast>、");
            return sb.append("<tryreturn>、");
        } finally {
            sb.append("<finally>");
            throw new RuntimeException("finally exception");
        }
    }

    @Test
    public void testm1() {


        System.out.println(m3());

    }


    @Test
    public void test() {

        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        final Class<?> aClass = Class.forName("com.roily.booknode.pdai._06Exception.DDDD");

        final Object o = aClass.newInstance();

    }
}

class DDDD {

    String str;

    public DDDD(String str) {
        this.str = str;
    }
    //
    //public DDDD() {
    //}
}
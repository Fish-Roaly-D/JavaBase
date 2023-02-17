package com.roily.booknode.javatogod._05fanx.brige;

import com.roily.booknode.javatogod._01faceobj.javakeywords.aboutstatic.Son;
import org.junit.Test;

/**
 * @Date: 2023/02/17/17:25
 * @Description:
 */
public class TestFanExtends {

    @Test
    public void test() {
        // 1 编译前类型检查错误
        // Person<Integer> person = new SonZD();

        // 2 可以通过编译，但是在调用桥接方法时，需要类型强转，integer强转为String会爆出ClassCastException
        Person person = new SonZD();
        person.method(1);
    }

}


class Person<T> {
    T t;

    void method(T t) {
    }
}

class SonZD extends Person<String> {
    @Override
    void method(String s) {
        super.method(s);
    }
}

class SonNotZD extends Person {
    @Override
    void method(Object o) {
        super.method(o);
    }
}
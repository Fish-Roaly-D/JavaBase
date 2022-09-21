package com.roily.booknode.javatogod._09sugar;

import com.google.common.cache.RemovalListener;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Date: 2022/09/07/10:07
 * @Description:
 */
public class TestLambda2 {
    /**
     * 内部类
     */
    class ClassInner implements Demo {
        @Override
        public void method() {
        }
    }

    /**
     * 静态内部类
     */
    static class StaticClassInner implements Demo {
        @Override
        public void method() {
        }
    }

    public static void main(String[] args) {
        /**
         * 匿名内部类
         */
        final Demo demo = new Demo() {
            @Override
            public void method() {
            }
        };
        final Demo demo2 = new Demo() {
            @Override
            public void method() {
            }
        };

        /**
         * lambda表达式
         */
        Demo demo1 = () -> {
        };

        //基本数据类型，不可变
        int i = 10;
        Demo demo3 = () -> {
            // i = 1;
        };
        //引用类型，可使用内部修改方法来修改内部属性值
        //但不可修改引用
        StringBuilder sb = new StringBuilder();
        Demo demo4 = () -> {
            sb.append("2");
            // sb = null;
        };
        Demo demo5 = () -> {
            // sb = null;
        };
    }

}

interface Demo {
    /**
     * 没有参数，返回值为null
     */
    void method();
}

/**
 * 普通外部类
 */
class ClassOuter implements Demo {
    @Override
    public void method() {
    }
}
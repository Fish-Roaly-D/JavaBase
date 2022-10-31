package com.roily.booknode.pdai._05annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Date: 2022/10/31/16:25
 * @Description:
 */
public @interface RetentionTest {
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface RetentionTest1 {
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@interface RetentionTest2 {
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface RetentionTest3 {
}

class TestRetention{

    @RetentionTest1
    void m1(){

    }
    @RetentionTest2
    void m2(){

    }

    @RetentionTest3
    void m3(){

    }

}
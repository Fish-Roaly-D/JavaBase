package com.roily.designpatterns.dp05_lsp.error_demo;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName PersonBase.java
 * @author: RoilyFish
 * @date: 2022/5/31 2:00
 */
public class PersonBase {

    //在程序员A得眼里，所有人都喜欢漂亮得女孩子
    void like(){
        System.out.println("喜欢漂亮的女孩子");
    }

    @Test
    public void test(){

        PersonBase personA = new PersonA();
        PersonBase personB = new PersonB();
        personA.like();
        personB.like();

        PersonBase personC = new PersonC();
        personC.like();

    }

}

class PersonA extends PersonBase {

    @Override
    void like() {
        super.like();
    }

}

class PersonB extends PersonBase {
    @Override
    void like() {
        super.like();
    }
}

class PersonC extends PersonBase {
    @Override
    void like() {
        System.out.println("喜欢可爱的女孩子");
    }
}

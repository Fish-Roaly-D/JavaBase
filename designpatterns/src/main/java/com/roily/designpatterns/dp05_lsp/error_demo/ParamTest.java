package com.roily.designpatterns.dp05_lsp.error_demo;

/**
 * @version 1.0.0
 * @Description 子类对于参数的约束相比于父类较为宽松
 * @ClassName ParamTest.java
 * @author: RoilyFish
 * @date: 2022/5/31 2:24
 */
public class ParamTest {
}

class Father {
    void doSomeThing(int i) {
        System.out.println(i);
    }
}

class Son extends Father {

    @Override
    void doSomeThing(int i) {
        if (i > 100)
            super.doSomeThing(i);
    }
}
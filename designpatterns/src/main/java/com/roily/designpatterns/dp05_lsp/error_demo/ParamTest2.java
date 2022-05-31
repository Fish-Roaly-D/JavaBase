package com.roily.designpatterns.dp05_lsp.error_demo;

/**
 * @version 1.0.0
 * @Description 子类对于参数的约束相比于父类较为宽松
 * @ClassName ParamTest.java
 * @author: RoilyFish
 * @date: 2022/5/31 2:24
 */
public class ParamTest2 {

}

class Father2 {
    Comparable doSomeThing(Integer i) {
        return i;
    }
}

class Son2 extends Father2 {
    @Override
    Integer doSomeThing(Integer i) {
        return i;
    }
}

class Father3 {
    Comparable doSomeThing(Integer i) throws Exception {

        if (i < 0) {
            throw new Exception("参数小于0");
        }

        return i;
    }
}

class Son3 extends Father3 {
    @Override
    Comparable doSomeThing(Integer i) throws Exception {

        return super.doSomeThing(i);
    }
}
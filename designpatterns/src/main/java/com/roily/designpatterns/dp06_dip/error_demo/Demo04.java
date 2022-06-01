package com.roily.designpatterns.dp06_dip.error_demo;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Demo04.java
 * @author: RoilyFish
 * @date: 2022/5/31 18:45
 */
public class Demo04 {

    @Test
    public void test() {
        IProgramLD4 lJava = new LJavaD4();
        IProgramLD4 lgo = new LgoD4();

        ProGrammerD4 proGrammer1 = new ProGrammerD4();
        proGrammer1.setLanguage(lJava);
        proGrammer1.work();

        ProGrammerD4 proGrammer2 = new ProGrammerD4();
        proGrammer2.setLanguage(lgo);
        proGrammer2.work();
    }

}


interface IProgramLD4 {
    void majorIn();
}

class LJavaD4 implements IProgramLD4 {
    @Override
    public void majorIn() {
        System.out.println("主修Java");
    }
}

class LgoD4 implements IProgramLD4 {
    @Override
    public void majorIn() {
        System.out.println("主修Go");
    }
}

class ProGrammerD4 {

    private IProgramLD4 language;

    public void setLanguage(IProgramLD4 language) {
        this.language = language;
    }

    void work() {
        language.majorIn();
    }
}
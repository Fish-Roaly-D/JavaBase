package com.roily.designpatterns.dp06_dip.error_demo;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description 构造器赋值
 * @ClassName Demo03.java
 * @author: RoilyFish
 * @date: 2022/5/31 18:38
 */
public class Demo03 {
    @Test
    public void test(){

        IProgramL lJava = new LJava();
        IProgramL lgo = new Lgo();

        ProGrammer proGrammer1 = new ProGrammer(lJava);

        proGrammer1.work();

        ProGrammer proGrammer2 = new ProGrammer(lgo);

        proGrammer2.work();

    }
}

interface IProgramL{
    void majorIn();
}
class LJava implements IProgramL{
    @Override
    public void majorIn() {
        System.out.println("主修Java");
    }
}
class Lgo implements IProgramL{
    @Override
    public void majorIn() {
        System.out.println("主修Go");
    }
}
class ProGrammer{

    private IProgramL language;

    public ProGrammer(IProgramL language) {
        this.language = language;
    }

    void work(){
        language.majorIn();
    }
}
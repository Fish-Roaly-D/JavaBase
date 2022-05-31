package com.roily.designpatterns.do06_dip.error_demo;

/**
 * @version 1.0.0
 * @Description 测试抽象不应该依赖于细节
 * @ClassName demo02.java
 * @author: RoilyFish
 * @date: 2022/5/31 18:16
 */
public class demo02 {


}

class ProgramLanguageJAVA {
    void majorIn() {
        System.out.println("主攻java");
    }
}

interface Programmer02 {
    void work(ProgramLanguageJAVA programLanguageJAVA);
}
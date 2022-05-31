package com.roily.designpatterns.do06_dip.error_demo;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Programmer.java
 * @author: RoilyFish
 * @date: 2022/5/31 18:10
 */
public class Programmer {

    /**
     * 高层模块依赖底层模块。
     * 细节应该依赖于抽象，此处依赖于细节
     * @param programLanguageJava
     */

    public void majorIn(ProgramLanguageJava programLanguageJava){
        programLanguageJava.java();
    }

}
class ProgramLanguageJava {

    public void java(){
        System.out.println("java语言");
    }

}
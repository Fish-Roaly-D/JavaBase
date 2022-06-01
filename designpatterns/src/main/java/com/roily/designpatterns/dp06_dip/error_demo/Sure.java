package com.roily.designpatterns.dp06_dip.error_demo;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Sure.java
 * @author: RoilyFish
 * @date: 2022/5/31 18:29
 */
public class Sure {

    @Test
    public void test() {

        ILanguage ljava = new Ljava();
        ILanguage lGo = new LGo();

        LProgrammer lProgrammer = new LProgrammer();

        lProgrammer.work(lGo);
        lProgrammer.work(ljava);
    }
}

interface ILanguage {
    void majorIn();
}

interface IProgrammer {
    void work(ILanguage language);
}

class LProgrammer implements IProgrammer {
    @Override
    public void work(ILanguage language) {
        language.majorIn();
    }
}

class Ljava implements ILanguage {

    @Override
    public void majorIn() {
        System.out.println("主攻java");
    }
}

class LGo implements ILanguage {

    @Override
    public void majorIn() {
        System.out.println("主攻Go");
    }
}
package com.roily.designpatterns.dpmain.prototype.aboutclone.adapter;

/**
 * @version 1.0.0
 * @Description 适配器
 * @ClassName Rosetta2.java
 * @author: RoilyFish
 * @date: 2022/6/6 18:38
 */
public class Rosetta2 implements ISoftware{

    @Override
    public String system() {
        return "";
    }

    @Override
    public String run(MacPC macPC) {
        System.out.println("使用Rosetta转译运行");
        return null;
    }
}

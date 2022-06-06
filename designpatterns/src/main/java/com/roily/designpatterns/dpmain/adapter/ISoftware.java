package com.roily.designpatterns.dpmain.adapter;

/**
 * @version 1.0.0
 * @Description 软件抽象类
 * @ClassName ISoftware.java
 * @author: RoilyFish
 * @date: 2022/6/6 18:13
 */
public interface ISoftware {
    //arm架构 还是X86架构
    String system();

    //运行
    String run(MacPC macPC);
}

package com.roily.designpatterns.dpmain.facade;

/**
 * @version 1.0.0
 * @Description
 * @ClassName CarMaker.java
 * @author: RoilyFish
 * @date: 2022/6/7 16:51
 */
public class CarMaker {


    public void makeCar() {
        //第一步：设计
        System.out.println("设计。。。。。。");

        //第二步：生产配件
        System.out.println("生产配件。。。。。。");

        //第三步：组装
        System.out.println("组装。。。。。。");

        //第四步：测试
        System.out.println("测试。。。。。。");

        //第五步：优化
        System.out.println("优化。。。。。。");

        //第六步：生产
        System.out.println("生产。。。。。。");

        System.out.println("车子出来了");

    }

}

package com.roily.designpatterns.dp07_LOD;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Demo03.java
 * @author: RoilyFish
 * @date: 2022/5/31 23:59
 */
public class Demo03 {

    @Test
    public void test(){

        Engineer engineer = new Engineer();
        Boss boss = new Boss();
        boss.create(engineer);

    }
}

//造个飞机
class Engineer{
    String eNo;
    void draw(){
        System.out.println("制图");
    }
    void components(){
        System.out.println("制造零件");
    }
    void install(){
        System.out.println("组装");
    }
}
//老板说造个飞机
class Boss{

    void create(Engineer engineer){
        engineer.draw();
        engineer.components();
        engineer.install();
    }

}
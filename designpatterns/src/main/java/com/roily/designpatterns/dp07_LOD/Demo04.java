package com.roily.designpatterns.dp07_LOD;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName Demo04.java
 * @author: RoilyFish
 * @date: 2022/6/1 0:06
 */
public class Demo04 {

    @Test
    public void test() {
        Engineer2 engineer = new Engineer2();
        Boss2 boss = new Boss2();
        boss.create(engineer);
    }


}

//造个飞机
class Engineer2 {
    private void draw() {
        System.out.println("制图");
    }

    private void components() {
        System.out.println("制造零件");
    }

    private void install() {
        System.out.println("组装");
    }

    public void make() {
        this.draw();
        this.components();
        this.install();
    }
}

//老板说造个飞机
class Boss2 {

    void create(Engineer2 engineer) {
        engineer.make();
    }

}
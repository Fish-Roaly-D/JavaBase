package com.roily.designpatterns.dp02_spr.ok_demo;


/**
 * @version 1.0.0
 * @Description
 * @ClassName OkDemo.java
 * @author: RoilyFish
 * @date: 2022/5/30 23:02
 */
public class OkDemo {

}

class PersonInfo {

}

interface IPersonActivity {

    void eat(PersonInfo personInfo);

    void learn(PersonInfo personInfo);

    void sleep(PersonInfo personInfo);

}

class Person implements IPersonActivity {


    @Override
    public void eat(PersonInfo personInfo) {
        //doEat
    }

    @Override
    public void learn(PersonInfo personInfo) {
        //doLearn
    }

    @Override
    public void sleep(PersonInfo personInfo) {
        //doSleep
    }
}
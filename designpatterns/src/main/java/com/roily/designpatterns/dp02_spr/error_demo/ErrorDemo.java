package com.roily.designpatterns.dp02_spr.error_demo;

/**
 * @version 1.0.0
 * @Description
 * @ClassName OkDemo.java
 * @author: RoilyFish
 * @date: 2022/5/30 23:02
 */
public class ErrorDemo {

}

class PersonInfo {

}

enum Activity {
    EAT, LEARN, SLEEP;
}

interface IPersonActivity {

    void personActivity(Activity activity, PersonInfo personInfo);

}
class Person implements IPersonActivity{
    @Override
    public void personActivity(Activity activity, PersonInfo personInfo) {

        if (activity == Activity.EAT){
            //doEat
        }else if (activity == Activity.LEARN){
            //doLearn
        }else if (activity == Activity.SLEEP){
            //doSleep
        }
    }
}
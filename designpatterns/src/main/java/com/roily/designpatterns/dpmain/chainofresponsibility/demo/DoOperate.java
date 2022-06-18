package com.roily.designpatterns.dpmain.chainofresponsibility.demo;

/**
 * @className：DoOperate
 * @author: rolyfish
 * @description: 做校验
 * @dte: 2022/6/18 00:33
 */
public class DoOperate {


    public static void main(String[] args) {
        final Person person = new Person()
                .setAge(220)
                .setSmokeYear(5);
        SmokeHandler smokeHandler = new SmokeHandler();
        AgeHandler ageHandler = new AgeHandler();
        ageHandler.setHandler(smokeHandler);
        ageHandler.doOperate(person);
    }

}

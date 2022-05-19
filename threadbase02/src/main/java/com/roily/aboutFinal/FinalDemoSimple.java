package com.roily.aboutFinal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName FinalDemoSimple.java
 * @author: RoilyFish
 * @date: 2022/3/19 21:06
 */
public class FinalDemoSimple {



}


class Person{

    //普通域
    private int age;
    private static Person person;

    public Person() {
        this.age = 20;
    }

    public static void getP() {
        Person p = person;
        System.out.println(p.age);
    }

    public static void setP() {
        person = new Person();
    }

    public static void main(String[] args) {

        Runnable runnable1 = () -> Person.getP();
        Runnable runnable2 = () -> Person.setP();

        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<?> submit1 = service.submit(runnable2);
        Future<?> submit = service.submit(runnable1);

        service.shutdown();

    }
}
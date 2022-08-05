package com.roily.jvm.day01;

/**
 * @Date: 2022/08/04/11:27
 * @Description:
 */
public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("Person main方法");
    }
}
package com.roily.injectway.constructor.javaconfig;

/**
 * @Date: 2022/09/27/14:34
 * @Description:
 */
public class Person {

    String name;
    String age;
    String email;

    public Person(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

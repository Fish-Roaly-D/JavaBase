package com.roily.entity;

/**
 * @Date: 2022/09/29/19:03
 * @Description:
 */
public class Person {
    public Person() {
    }

    String name;
    String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}

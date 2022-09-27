package com.roily.entity;

/**
 * @Date: 2022/09/27/14:10
 * @Description:
 */
public class User {

    String name;

    public User() {
        System.out.println("User   init");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("seName");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

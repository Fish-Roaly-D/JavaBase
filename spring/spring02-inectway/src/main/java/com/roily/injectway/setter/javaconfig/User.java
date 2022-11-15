package com.roily.injectway.setter.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/09/27/14:10
 * @Description:
 */
@Component
public class User {

    String name;

    public User() {
        System.out.println("User   init");
    }

    @Autowired
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

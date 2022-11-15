package com.roily.designpatterns.dpmain.strategy.strategydemo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @className：Person
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 00:51
 */
@Data
@AllArgsConstructor
public class Person {

    private String name;

    private Integer age;

    private Date birthDae;

    @Override
    public boolean equals(Object obj) {
        Person target = (Person) obj;
        return
                this.getAge().equals(target.getAge())
                &&
                this.getName().equals(target.getName());
    }
}

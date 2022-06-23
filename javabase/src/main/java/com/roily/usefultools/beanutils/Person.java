package com.roily.usefultools.beanutils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Calendar;
import java.util.Date;

/**
 * @className：Person
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/23 23:40
 */
@Data
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Person {
    Long id;
    String name;
    Integer age;
    String address;
    Date birth;

    public static Person getDefault() {
        return new Person()
                .setId(1L)
                .setName("yyc")
                .setAge(22)
                .setAddress("大套")
                .setBirth(Calendar.getInstance().getTime());
    }

    public Person(String name) {
        this.name = name;
    }
}

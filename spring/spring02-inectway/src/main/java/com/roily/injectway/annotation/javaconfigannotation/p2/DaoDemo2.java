package com.roily.injectway.annotation.javaconfigannotation.p2;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Date: 2022/10/11/10:05
 * @Description:
 */
// @Component
public class DaoDemo2 {
    String value;

    @Autowired
    public void setValue(String value) {
        this.value = value;
    }
}

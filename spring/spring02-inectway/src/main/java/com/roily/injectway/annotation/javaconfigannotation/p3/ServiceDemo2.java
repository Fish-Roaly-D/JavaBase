package com.roily.injectway.annotation.javaconfigannotation.p3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/10/11/10:05
 * @Description:
 */
@Component
public class ServiceDemo2 {

    DaoDemo2 daoDemo;

    @Autowired
    public void setDaoDemo(DaoDemo2 daoDemo) {
        this.daoDemo = daoDemo;
    }

}

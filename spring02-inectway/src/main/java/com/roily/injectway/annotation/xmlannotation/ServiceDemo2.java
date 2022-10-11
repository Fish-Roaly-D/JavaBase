package com.roily.injectway.annotation.xmlannotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Date: 2022/10/11/10:05
 * @Description:
 */
public class ServiceDemo2 {

    DaoDemo daoDemo;

    @Autowired
    public void setDaoDemo(DaoDemo daoDemo) {
        this.daoDemo = daoDemo;
    }
    
}

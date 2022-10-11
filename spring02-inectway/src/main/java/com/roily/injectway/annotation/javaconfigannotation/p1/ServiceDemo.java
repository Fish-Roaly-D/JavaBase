package com.roily.injectway.annotation.javaconfigannotation.p1;

/**
 * @Date: 2022/10/11/10:05
 * @Description:
 */
public class ServiceDemo {

    DaoDemo daoDemo;

    public ServiceDemo setDaoDemo(DaoDemo daoDemo) {
        this.daoDemo = daoDemo;
        return this;
    }

}

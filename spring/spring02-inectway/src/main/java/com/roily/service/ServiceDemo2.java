package com.roily.service;

import com.roily.dao.DaoDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/09/27/16:49
 * @Description:
 */
@Component
public class ServiceDemo2 {

    private DaoDemo daoDemo1;

    @Autowired
    @Qualifier("daoDemoAlias")
    public void setDaoDemo(DaoDemo daoDemo1) {
        this.daoDemo1 = daoDemo1;
    }

}

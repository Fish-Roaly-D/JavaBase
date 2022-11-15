package com.roily.autowriteresourceinject.inject.bytype;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @Date: 2022/10/12/14:08
 * @Description:
 */
@Component
public class ServiceComponent {

    private DaoComponent1 daoComponent1;

    @Inject
    public void setDaoComponent1(DaoComponent1 daoComponent1) {
        this.daoComponent1 = daoComponent1;
    }

}

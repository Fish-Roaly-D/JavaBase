package com.roily.autowriteresourceinject.inject.byname;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @Date: 2022/10/12/14:08
 * @Description:
 */
@Component
public class ServiceComponent {

    private DaoComponent1 daoComponent;

    @Inject
    @Named(value = "daoComponent2")
    public void setDaoComponent1(DaoComponent1 daoComponent1) {
        this.daoComponent = daoComponent1;
    }

}

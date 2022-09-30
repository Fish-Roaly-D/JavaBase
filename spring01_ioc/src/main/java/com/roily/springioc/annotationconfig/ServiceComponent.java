package com.roily.springioc.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Date: 2022/09/30/9:47
 * @Description:
 */
@Service(value = "xxxx")//可自定义组件名称
public class ServiceComponent {

    DaoComponent daoComponent;

    @Autowired
    @Qualifier("daoComponent")
    public void setDaoComponent(DaoComponent daoComponent) {
        this.daoComponent = daoComponent;
    }

}

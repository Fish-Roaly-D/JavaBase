package com.roily.springioc.javaconfig;

/**
 * @Date: 2022/09/30/9:47
 * @Description:
 */
public class ServiceComponent {

    DaoComponent daoComponent;
    //setter注入必须存在对应setter方法
    public void setDaoComponent(DaoComponent daoComponent) {
        this.daoComponent = daoComponent;
    }
}

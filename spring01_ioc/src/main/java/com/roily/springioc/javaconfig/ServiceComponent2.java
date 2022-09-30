package com.roily.springioc.javaconfig;

/**
 * @Date: 2022/09/30/9:47
 * @Description:
 */
public class ServiceComponent2 {

    DaoComponent daoComponent;
    //构造器注入必须存在参数一致的构造方法
    public ServiceComponent2(DaoComponent daoComponent) {
        this.daoComponent = daoComponent;
    }

}

package com.roily.springioc.annotationconfig;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2022/09/30/9:47
 * @Description:
 */
@Service
public class ServiceComponent2 {

    DaoComponent daoComponent;

    //注解配置，构造器注入，无需显示注入
    //注入过程：首先通过type，如果找到多个则按参数名注入
    /*@Autowired*/
    public ServiceComponent2(/*@Autowired*/ DaoComponent daoComponent0x) {
        this.daoComponent = daoComponent0x;
    }

}

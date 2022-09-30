package com.roily.springioc.injectbyname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Date: 2022/09/30/9:47
 * @Description:
 */
@Service
public class ServiceComponent {

    @Autowired
    @Qualifier("daoDemo01")
    DaoComponent daoComponent;

}

package com.roily.autowriteresourceinject.autowrite.bytype;

import org.springframework.stereotype.Component;

/**
 * @Date: 2022/10/12/10:24
 * @Description:
 */
@Component
public class ServiceComponent {

    DaoComponent daoComponent;

    public ServiceComponent(DaoComponent daoComponent) {
        this.daoComponent = daoComponent;
    }
}

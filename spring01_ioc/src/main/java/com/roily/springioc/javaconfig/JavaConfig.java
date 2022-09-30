package com.roily.springioc.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * @Date: 2022/09/30/10:24
 * @Description:
 */
public class JavaConfig {

    @Bean("daoComponent1")
    public DaoComponent daoComponent() {
        return new DaoComponent();
    }

    @Bean("daoComponent2")
    public DaoComponent daoComponentX() {
        return new DaoComponent();
    }

    @Bean("serviceComponent")
    public ServiceComponent serviceComponent(@Autowired @Qualifier("daoComponent1") DaoComponent daoComponent) {
        final ServiceComponent serviceComponent = new ServiceComponent();
        serviceComponent.setDaoComponent(daoComponent);
        return serviceComponent;
    }


}

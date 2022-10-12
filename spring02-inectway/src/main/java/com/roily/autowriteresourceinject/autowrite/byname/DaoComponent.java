package com.roily.autowriteresourceinject.autowrite.byname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/10/12/10:24
 * @Description:
 */
@Component
public class DaoComponent {

    String value;

    public DaoComponent(@Autowired(required = false) @Qualifier("value1") String value) {
        this.value = value;
    }

}

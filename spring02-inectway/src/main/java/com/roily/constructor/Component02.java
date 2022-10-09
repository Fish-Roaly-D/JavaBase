package com.roily.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/10/09/15:54
 * @Description:
 */
@Component
public class Component02 {

    Component01 component01;

    /**
     * 通过构造器注入，可以省略@AutoWrite
     *
     * @param component01
     */
    public Component02(@Autowired @Qualifier("component01alias") Component01 component01) {
        this.component01 = component01;
    }

}

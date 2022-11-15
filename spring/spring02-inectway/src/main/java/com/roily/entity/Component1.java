package com.roily.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/09/27/16:23
 * @Description:
 */
// @Component
public class Component1 {

    // @Autowired
    Component2 component2;

    @Autowired
    public Component1(final Component2 component2) {
        this.component2 = component2;
    }

    public void method() {
        component2.method();
    }

    public void setComponent2(Component2 component2) {
        this.component2 = component2;
    }

}

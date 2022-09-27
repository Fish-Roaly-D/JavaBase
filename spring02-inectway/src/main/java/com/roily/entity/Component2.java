package com.roily.entity;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/09/27/16:23
 * @Description:
 */
@Component
public class Component2 {

    // @Autowired
    Component1 component1;

    @Autowired
    public Component2(final Component1 component1) {
        this.component1 = component1;
    }

    public void method() {
        component1.method();
    }

    public void setComponent1(Component1 component1) {
       this.component1 = component1;
    }
}

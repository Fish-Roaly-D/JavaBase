package com.roily.byname;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Date: 2022/10/09/15:54
 * @Description:
 */
@Component
public class Component02 {

    //默认按照类型注入,如果存在多个同类型不同名bean，需要配合@Qualifier使用
    @Autowired
    @Qualifier("component01alias")
    Component01 component01;

    /**
     * 通过构造器注入，可以省略@AutoWrite
     * @param component01
     */
    // public Component02(Component01 component01) {
    //     this.component01 = component01;
    // }

}

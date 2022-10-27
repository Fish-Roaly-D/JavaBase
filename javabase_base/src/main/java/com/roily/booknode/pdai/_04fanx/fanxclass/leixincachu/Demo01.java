package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import lombok.Data;

/**
 * @Date: 2022/10/27/11:18
 * @Description: 非限定通配符
 */
@Data
public class Demo01<T> {

    T t;

    public void method() {
        /**
         * 这里我们声明范型参数为String
         * 由于这是非限定通配符，在编译器期间会进行类型擦除，范型类型替换为Object
         */
        final Demo01<String> stringDemo01 = new Demo01<>();
        /**
         * 由于类型擦除，这里的getT返回类型为Object
         * 这里我们使用String接收，所以必须进行类型强转
         */
        final String t = stringDemo01.getT();

        //setT参数为Object，允许向上转型，可接收String类型
        stringDemo01.setT("str");
    }

}

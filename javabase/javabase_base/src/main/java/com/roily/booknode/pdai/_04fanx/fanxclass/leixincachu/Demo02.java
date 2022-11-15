package com.roily.booknode.pdai._04fanx.fanxclass.leixincachu;

import lombok.Data;

/**
 * @Date: 2022/10/27/11:18
 * @Description: 限定通配符
 */
@Data
public class Demo02<T extends Comparable> {

    T t;

    public void method() {
        /**
         * 这里我们声明范型参数为String
         * 由于这是限定通配符，在编译器期间会进行类型擦除，范型类型替换为范型左边界Comparable
         */
        final Demo02<String> stringDemo01 = new Demo02();
        /**
         * 由于类型擦除，这里的getT返回类型为Comparable
         * 这里我们使用String接收，所以必须进行类型强转
         */
        final String t = stringDemo01.getT();

        //setT参数为Comparable，允许向上转型，可接收String类型
        stringDemo01.setT("str");
    }

}

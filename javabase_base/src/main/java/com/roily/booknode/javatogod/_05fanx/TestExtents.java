package com.roily.booknode.javatogod._05fanx;

import java.util.List;

/**
 * @Date: 2022/08/26/18:28
 * @Description:
 */
public class TestExtents {

    /**
     * 表示上界，为边界当前类或子类
     *
     * @param list
     */
    public void  tesExtents(List<? extends Fruit> list) {
        //不可添加，因为在添加是不可确认唯一类型
        // list.add(new Fruit());
        // list.add((Apple)new Fruit());

        final Fruit fruit = list.get(0);
    }

    /**
     * 表示下界，为边界当前类或边界父类
     *
     * @param list
     */
    public static void tesSuper(List<? super Apple> list) {
        //不可放Fruit因为不可保证Apple的父类只有Fruit一个
        // list.add(new Fruit());
        list.add(new Apple());
        list.add(new AppleSon());


        final Object object = list.get(0);
    }

    public static void main(String[] args) {

        //tesSuper(new ArrayList<>());

        final Apple fruit = (Apple)new Fruit();

    }


}

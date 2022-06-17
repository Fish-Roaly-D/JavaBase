package com.roily.designpatterns.dpmain.iterator;

/**
 * @className：Iiterator
 * @author: rolyfish
 * @description: 自定义抽象迭代器接口
 * @dte: 2022/6/17 22:51
 */
public interface Iiterator<E> {

    /**
     * 判断集合是否还存在元素
     * @return Boolean.class
     */
    Boolean hashNext();

    /**
     * 获取下一个元素
     * @return E
     */
    E next();

}

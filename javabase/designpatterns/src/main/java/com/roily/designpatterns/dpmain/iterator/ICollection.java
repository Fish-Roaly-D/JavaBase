package com.roily.designpatterns.dpmain.iterator;

/**
 * @className：ICollection
 * @author: rolyfish
 * @description: 自定义抽象集合接口
 * @dte: 2022/6/17 22:54
 */
public interface ICollection<E> {

    /**
     * 提供获取迭代器的方法
     *
     * @return E
     */
    Iiterator<E> iterator();

    /**
     * 获取集合首个元素
     *
     * @return
     */
    E getFirstElement();

    /**
     * 获取元素
     * @param index
     * @return
     */
    E get(int index);

}

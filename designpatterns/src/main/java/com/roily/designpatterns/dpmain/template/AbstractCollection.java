package com.roily.designpatterns.dpmain.template;

/**
 * @className：AbstractCollection
 * @author: rolyfish
 * @description: 抽象集合
 * @dte: 2022/6/17 12:34
 */
public abstract class AbstractCollection {

    /**
     * 获取元素
     * @return String.class
     */
    abstract String getFirstElement();

    /**
     * 默认获取首个元素
     * @return
     */
    String getElement(){
       return getFirstElement();
    }

}

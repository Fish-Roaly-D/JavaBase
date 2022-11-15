package com.roily.designpatterns.dp08_OCP.demo01;

/**
 * @version 1.0.0
 * @Description 书本接口
 * @ClassName IBook.java
 * @author: RoilyFish
 * @date: 2022/6/1 22:56
 */
public interface IBook {

    //约束书本基本功能

    /**
     * 价格
     */
    Integer getPrice();

    /**
     * 作者
     */
    String getAuthor();

    /**
     * 名称
     */
    String getName();

}

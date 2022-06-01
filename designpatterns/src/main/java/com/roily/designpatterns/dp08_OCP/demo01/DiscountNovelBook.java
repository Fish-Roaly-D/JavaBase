package com.roily.designpatterns.dp08_OCP.demo01;

/**
 * @version 1.0.0
 * @Description 打折书本
 * @ClassName DiscountNovelBook.java
 * @author: RoilyFish
 * @date: 2022/6/1 23:26
 */
public class DiscountNovelBook extends NovelBook {

    public DiscountNovelBook(Integer price, String author, String name) {
        super(price, author, name);
    }

    //复写getPrice方法
    @Override
    public Integer getPrice() {
        final Integer price = super.getPrice();
        Integer rPrice = 0;
        if (price > 50) {
            rPrice = price / 10 * 9;
        } else rPrice = price;
        return rPrice;
    }
}

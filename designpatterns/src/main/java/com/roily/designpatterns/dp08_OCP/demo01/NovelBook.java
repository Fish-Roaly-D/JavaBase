package com.roily.designpatterns.dp08_OCP.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version 1.0.0
 * @Description 小说书本
 * @ClassName NovelBook.java
 * @author: RoilyFish
 * @date: 2022/6/1 22:58
 */
@Data
@AllArgsConstructor
public class NovelBook implements IBook {

    private Integer price;
    private String author;
    private String name;

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getName() {
        return name;
    }

}

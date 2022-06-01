package com.roily.designpatterns.dp08_OCP.demo01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @Description 书店
 * @ClassName BookStore.java
 * @author: RoilyFish
 * @date: 2022/6/1 23:00
 */
public class BookStore {

    private List<IBook> list = new ArrayList<>();

    public void init(){
        //
        //list.add(new NovelBook(100,"bookname1","bookauthor1"));
        //list.add(new NovelBook(100,"bookname2","bookauthor2"));
        //list.add(new NovelBook(100,"bookname3","bookauthor3"));
        //list.add(new NovelBook(100,"bookname4","bookauthor4"));
        //
        list.add(new DiscountNovelBook(100,"bookname1","bookauthor1"));
        list.add(new DiscountNovelBook(100,"bookname2","bookauthor2"));
        list.add(new DiscountNovelBook(100,"bookname3","bookauthor3"));
        list.add(new DiscountNovelBook(100,"bookname4","bookauthor4"));

    }

    public void sell(List<IBook> list){
        list.forEach(book -> {
            System.out.println("卖书："
                    +book.getName()
                    +"\t\t" +book.getAuthor()
                    +"\t\t"+book.getPrice());
        });
    }


    @Test
    public void test(){

        BookStore bookStore = new BookStore();
        bookStore.init();
        bookStore.sell(bookStore.list);
    }

}

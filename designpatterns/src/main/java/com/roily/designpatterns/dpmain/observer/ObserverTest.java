package com.roily.designpatterns.dpmain.observer;

/**
 * @className：O
 * @author: rolyfish
 * @description: 观察者模式测试
 * @dte: 2022/6/17 13:29
 */
public class ObserverTest {


    public static void main(String[] args) {

        Blog blog = new Blog();
        blog.addObserver(new Observer("yyc1"));
        blog.addObserver(new Observer("yyc2"));
        blog.addObserver(new Observer("yyc3"));
        //发布博客通知所有订阅者
        blog.releaseBlog();
    }

}

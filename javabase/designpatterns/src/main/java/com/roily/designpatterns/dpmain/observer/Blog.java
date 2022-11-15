package com.roily.designpatterns.dpmain.observer;

/**
 * @className：Blog
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 13:28
 */
public class Blog extends AbstractBlog {

    @Override
    public void releaseBlog() {
        System.out.println("博客发布，通知所有订阅者");
        super.notifyAllObserver();
    }

}

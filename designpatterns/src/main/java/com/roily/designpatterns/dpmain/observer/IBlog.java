package com.roily.designpatterns.dpmain.observer;

/**
 * @className：IBlog
 * @author: rolyfish
 * @description: 博客抽象
 * @dte: 2022/6/17 13:21
 */
public interface IBlog {

    /**
     * 添加订阅者
     * @param observer
     */
    void addObserver(IObserver observer);

    /**
     * 取消订阅
     * @param observer
     */
    void delObserver(IObserver observer);

    /**
     * 通知所有订阅者
     */
    void notifyAllObserver();

    /**
     * 发布博客
     */
    void releaseBlog();

}

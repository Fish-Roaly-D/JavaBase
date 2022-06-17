package com.roily.designpatterns.dpmain.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @className：Blog
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 13:25
 */
public abstract class AbstractBlog implements IBlog{

    private List<IObserver> list = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        list.add(observer);
    }

    @Override
    public void delObserver(IObserver observer) {
        list.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        list.forEach(IObserver::notice);
    }

}

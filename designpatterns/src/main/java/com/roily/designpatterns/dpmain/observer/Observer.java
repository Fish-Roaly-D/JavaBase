package com.roily.designpatterns.dpmain.observer;

import lombok.Data;

/**
 * @className：Observer
 * @author: rolyfish
 * @description: 订阅者
 * @dte: 2022/6/17 13:18
 */
@Data
public class Observer implements IObserver {

    private String name;

    private Integer num = 0;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void notice() {
        System.out.println(this.getName()+"=>您订阅的文章已更新");
        num++;
    }

}

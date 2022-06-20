package com.roily.designpatterns.dpmain.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @className：CareMaker
 * @author: rolyfish
 * @description: 保存状态
 * @dte: 2022/6/20 13:03
 */
public class CareMaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void store(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index);
    }

}

package com.roily.designpatterns.dpmain.iterator;

import java.util.ArrayList;

/**
 * @className：MyCollection
 * @author: rolyfish
 * @description: 自定义集合
 * @dte: 2022/6/17 23:04
 */
public class MyCollection<E> implements ICollection<E> {

    private class MyCollectionIterator<E> implements Iiterator<E> {
        int currentIndex;
        public MyCollectionIterator() {
        }
        @Override
        public Boolean hashNext() {
            return arrayList.size() != currentIndex;
        }
        @Override
        public E next() {
            return (E) arrayList.get(currentIndex++);
        }
    }

    /**
     * 内部借助ArrayList实现
     */
    private ArrayList<E> arrayList = new ArrayList<>();

    {
        //初始化一些值
        for (int i = 0; i < 10; i++) {
            arrayList.add((E) Integer.valueOf(i));
        }
    }

    @Override
    public Iiterator<E> iterator() {
        return new MyCollectionIterator<>();
    }

    @Override
    public E getFirstElement() {
        return arrayList.get(0);
    }

    @Override
    public E get(int index) {
        return arrayList.get(index);
    }
}

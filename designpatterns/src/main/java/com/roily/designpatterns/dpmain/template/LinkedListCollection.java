package com.roily.designpatterns.dpmain.template;

import lombok.Data;

import java.util.LinkedList;

/**
 * @className：LinkedListCollection
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 12:41
 */
@Data
public class LinkedListCollection extends AbstractCollection {

    private LinkedList<String> list = new LinkedList();

    {
        list.add("a");
        list.add("b");
        list.add("c");
    }

    @Override
    String getFirstElement() {
        return list.getFirst();
    }

}


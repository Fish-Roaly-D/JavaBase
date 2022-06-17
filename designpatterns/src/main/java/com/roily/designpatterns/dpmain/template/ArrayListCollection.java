package com.roily.designpatterns.dpmain.template;

import lombok.Data;

import java.util.ArrayList;

/**
 * @className：ArrayListCollection
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/17 12:39
 */
@Data
public class ArrayListCollection extends AbstractCollection {

    private ArrayList<String> list = new ArrayList<>();
    {
        list.add("a");
        list.add("b");
        list.add("c");
    }
    @Override
    String getFirstElement() {
        return list.get(0);
    }
}

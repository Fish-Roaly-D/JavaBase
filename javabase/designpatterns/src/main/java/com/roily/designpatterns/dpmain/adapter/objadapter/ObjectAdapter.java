package com.roily.designpatterns.dpmain.adapter.objadapter;

import org.junit.Test;

/**
 * @className：ObjectAdapter
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 00:17
 */
public class ObjectAdapter {

    @Test
    public void test(){
        TargetAble adapter = new Adapter(new Source());
        adapter.method01();
        adapter.method02();
    }

}

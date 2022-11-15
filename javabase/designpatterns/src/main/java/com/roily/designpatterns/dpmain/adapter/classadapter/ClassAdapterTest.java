package com.roily.designpatterns.dpmain.adapter.classadapter;

import lombok.val;
import org.junit.Test;

/**
 * @className：ClassAdapterTest
 * @author: rolyfish
 * @description: 类的适配器的测试类
 * @dte: 2022/6/14 23:02
 */
public class ClassAdapterTest {

    @Test
    public void classAdapterTest01(){

        TargetAble adapter = new Adapter();
        adapter.method01();
        adapter.method02();
    }


}

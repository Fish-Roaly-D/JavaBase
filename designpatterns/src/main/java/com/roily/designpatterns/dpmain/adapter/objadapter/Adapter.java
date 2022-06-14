package com.roily.designpatterns.dpmain.adapter.objadapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 * @className：Adapter
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 00:15
 */
@Data
@AllArgsConstructor
public class Adapter implements TargetAble {

    /**
     * 将Source组合进来
     */
    private Source source;

    @Override
    public void method01() {
        source.method01();
    }

    @Override
    public void method02() {
        System.out.println("适配的method02");
    }
}

package com.roily.designpatterns.dpmain.chainofresponsibility.demo;

import org.springframework.util.ObjectUtils;

/**
 * @className：AgeHandler
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/18 00:30
 */
public class SmokeHandler extends AbstractHandler implements Handler{

    @Override
    public void doOperate(Person person) {

        final Handler handler = super.getHandler();
        if (person.getSmokeYear() > 10){
            System.out.println("烟龄大于10阻断");
            return;
        }
        System.out.println("烟龄校验结束，通过校验");

        if (!ObjectUtils.isEmpty(handler)){
            super.getHandler().doOperate(person);
        }

    }
}

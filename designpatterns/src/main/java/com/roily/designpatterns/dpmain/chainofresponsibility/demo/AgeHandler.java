package com.roily.designpatterns.dpmain.chainofresponsibility.demo;

import org.springframework.util.ObjectUtils;

/**
 * @className：AgeHandler
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/18 00:30
 */
public class AgeHandler extends AbstractHandler implements Handler{

    @Override
    public void doOperate(Person person) {
        final Handler handler = super.getHandler();
        if (person.getAge() > 80){
            System.out.println("年龄大于80阻断");
            return;
        }
        System.out.println("年龄校验结束，通过校验");
        if (!ObjectUtils.isEmpty(handler)){
            super.getHandler().doOperate(person);

        }
    }
}

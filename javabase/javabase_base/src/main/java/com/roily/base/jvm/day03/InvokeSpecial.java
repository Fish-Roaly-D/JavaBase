package com.roily.base.jvm.day03;

/**
 * @classname：InvokeSpecial
 * @author: rolyfish
 * @description: todo
 * @date: 2022/8/7 21:36
 */
public class InvokeSpecial {
    public void test(){

        Business business = new BusinessImpl();
        business.doWork();
    }
}

interface Business{

    void doWork();
}

class BusinessImpl implements Business{

    @Override
    public void doWork() {

    }
}
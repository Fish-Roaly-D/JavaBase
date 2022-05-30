package com.roily.designpatterns.dp01_spr.ok_demo;

import org.junit.Test;

/**
 * @version 1.0.0
 * @Description
 * @ClassName test.java
 * @author: RoilyFish
 * @date: 2022/5/30 22:41
 */
public class test {

    /**
     * 多态的具体表现
     */
    @Test
    public void test(){
        IUserInfo iUserInfo = new UserInfoImpl();
        IUserBusiness iUserBusiness = new UserInfoImpl();
        //分别只能调用各自抽像类
    }

}

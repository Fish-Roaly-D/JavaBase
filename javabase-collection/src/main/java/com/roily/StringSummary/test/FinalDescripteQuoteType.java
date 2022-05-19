package com.roily.StringSummary.test;

import com.roily.StringSummary.entity.User;

import java.util.Date;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
public class FinalDescripteQuoteType {

    //作为成员变量
    final User user = User.builder().userName("defaultName").age(20).birthDay(new Date()).build();


    public static void main(String[] args) {

        FinalDescripteQuoteType finalDescripteQuoteType = new FinalDescripteQuoteType();

        //引用类型  引用地址不可变
        //finalDescripteQuoteType.user = null;
        System.out.println(finalDescripteQuoteType.user);
        finalDescripteQuoteType.user.setAge(1000);
        System.out.println(finalDescripteQuoteType.user);

    }

}

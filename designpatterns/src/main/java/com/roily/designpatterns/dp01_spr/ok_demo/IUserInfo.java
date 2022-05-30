package com.roily.designpatterns.dp01_spr.ok_demo;

/**
 * @version 1.0.0
 * @Description 用户信息管理接口
 * @ClassName IUserInfo.java
 * @author: RoilyFish
 * @date: 2022/5/30 22:35
 */
public interface IUserInfo {

    //获取用户名称
    String getUserName();

    //获取用户密码
    String getUserPassword();

    //设置（修改）用户名称
    void setUserName();

    //设置（修改）用户密码
    void setUserPassword();

    boolean deleteUser();

}

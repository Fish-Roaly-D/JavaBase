package com.roily.designpatterns.dp01_spr.error_demo;

/**
 * @version 1.0.0
 * @Description 管理用户的接口
 * @ClassName IUserInfo.java
 * @author: RoilyFish
 * @date: 2022/5/30 13:34
 */
public interface IUserInfo {

    /**
     * 用户管理模块，将用户信息管理、权限管理放入同一个接口。
     *
     * 模拟一个耦合度较高的接口
     *
     */

    //获取用户名称
    String getUserName();

    //获取用户密码
    String getUserPassword();

    //设置（修改）用户名称
    void setUserName();

    //设置（修改）用户密码
    void setUserPassword();

    boolean deleteUser();

    //添加组织
    boolean addOrg(int orgId);

    //添加角色（使拥有权限）
    boolean addRole(int roleId);

}

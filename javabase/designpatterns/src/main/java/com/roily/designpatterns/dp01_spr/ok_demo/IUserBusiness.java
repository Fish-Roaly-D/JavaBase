package com.roily.designpatterns.dp01_spr.ok_demo;

/**
 * @version 1.0.0
 * @Description 用户权限管理接口
 * @ClassName IUserInfo.java
 * @author: RoilyFish
 * @date: 2022/5/30 22:35
 */
public interface IUserBusiness {

    //添加组织
    boolean addOrg(int orgId);

    //添加角色（使拥有权限）
    boolean addRole(int roleId);

}

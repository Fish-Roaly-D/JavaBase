package com.roily.designpatterns.dp01_spr.error_demo.Impl;

import com.roily.designpatterns.dp01_spr.error_demo.IUserInfo;

/**
 * @version 1.0.0
 * @Description
 * @ClassName UserInfo.java
 * @author: RoilyFish
 * @date: 2022/5/30 13:42
 */
public class UserInfo implements IUserInfo {

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserPassword() {
        return null;
    }

    @Override
    public void setUserName() {

    }

    @Override
    public void setUserPassword() {

    }

    @Override
    public boolean deleteUser() {
        return false;
    }

    @Override
    public boolean addOrg(int orgId) {
        return false;
    }

    @Override
    public boolean addRole(int roleId) {
        return false;
    }

}

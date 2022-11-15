package com.roily.designpatterns.dp01_spr.ok_demo;

import javax.jws.soap.SOAPBinding;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName UserInfoImpl.java
 * @author: RoilyFish
 * @date: 2022/5/30 22:39
 */
public class UserInfoImpl implements UserInfo {

    @Override
    public boolean addOrg(int orgId) {
        return false;
    }

    @Override
    public boolean addRole(int roleId) {
        return false;
    }

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
}

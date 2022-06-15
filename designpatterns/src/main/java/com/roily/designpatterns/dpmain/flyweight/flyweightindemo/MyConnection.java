package com.roily.designpatterns.dpmain.flyweight.flyweightindemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @className：MyConnection
 * @author: rolyfish
 * @description:
 * @dte: 2022/6/15 21:24
 */
@Getter
@Setter
@AllArgsConstructor
public class MyConnection implements IConnection{
    /**
     * 外部属性
     */
    Integer timeOut;

    String userName;

    String password;

    ConnectionPoll connectionPoll;

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getPassWord() {
        return this.password;
    }

    @Override
    public void release() {
        connectionPoll.add(this);
    }
}

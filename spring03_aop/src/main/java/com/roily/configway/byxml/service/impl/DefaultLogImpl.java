package com.roily.configway.byxml.service.impl;

import com.roily.configway.byxml.service.ILog;

/**
 * @Date: 2022/10/17/14:34
 * @Description:
 */
public class DefaultLogImpl implements ILog {

    @Override
    public void log() {
        System.err.println("ILog的默认实现");
    }

}

package com.roily.configway.byannotation.service.impl;

import com.roily.configway.byannotation.service.ILog;

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

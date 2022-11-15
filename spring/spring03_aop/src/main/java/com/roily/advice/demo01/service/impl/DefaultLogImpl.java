package com.roily.advice.demo01.service.impl;

import com.roily.configway.byannotation.service.ILog;
import org.springframework.stereotype.Service;

/**
 * @Date: 2022/10/17/14:34
 * @Description:
 */
// @Service
public class DefaultLogImpl implements ILog {

    @Override
    public void log() {
        System.err.println("ILog的默认实现");
    }

}

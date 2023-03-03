package com.hmdp.utils.redislock;

import lombok.Data;

/**
 * @author: rolyfish
 */
public class MyDefinedSimpleRedisLock implements ILock{


    @Override
    public boolean tryLock(long timeoutSec) {

        return false;
    }

    @Override
    public void unlock() {

    }
}

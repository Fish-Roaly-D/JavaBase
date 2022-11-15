package com.roily.spi.impl2;



import com.roiy.spi.IDriver;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Date: 2022/11/07/11:36
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        final ServiceLoader<IDriver> load = ServiceLoader.load(IDriver.class);
        final Iterator<IDriver> iterator = load.iterator();
        while (iterator.hasNext()) {
            final IDriver next = iterator.next();
            next.getConn();
        }
    }
}

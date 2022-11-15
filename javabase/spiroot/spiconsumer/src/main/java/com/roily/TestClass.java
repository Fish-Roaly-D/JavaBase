package com.roily;


import com.roiy.spi.IDriver;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Date: 2022/11/07/15:41
 * @Description:
 */
public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException {
        final ServiceLoader<IDriver> load = ServiceLoader.load(IDriver.class);
        final Iterator<IDriver> iterator = load.iterator();
        while (iterator.hasNext()) {
            final IDriver next = iterator.next();
            System.out.println("==========" + next.getClass() + "===========");
            next.getConn();
            next.service();
        }
    }

}

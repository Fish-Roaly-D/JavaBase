package com.roily.servlet.listening;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2022/11/14/18:14
 * @Description:
 */
public class SessionListening implements HttpSessionBindingListener {


    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 上下文对象
        final ServletContext servletContext = event.getSession().getServletContext();
        final AtomicInteger onlineNum = (AtomicInteger) servletContext.getAttribute("onlineNum");
        if (null != onlineNum) {
            AtomicInteger num = new AtomicInteger(0);
            num.incrementAndGet();
            servletContext.setAttribute("onlineNum", num);
        }
        onlineNum.incrementAndGet();
        System.out.println(onlineNum.get());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

        // 上下文对象
        final ServletContext servletContext = event.getSession().getServletContext();
        final AtomicInteger onlineNum = (AtomicInteger) servletContext.getAttribute("onlineNum");
        onlineNum.decrementAndGet();
        System.out.println(onlineNum.get());

    }
}

package com.roily.servlet.listening;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rolyfish
 * @Date: 2022/11/14/18:14
 * @Description:
 */
public class SessionListening implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated");
        // 上下文对象
        final ServletContext servletContext = se.getSession().getServletContext();
        //取出session注册个数
        AtomicInteger onlineNum = (AtomicInteger) servletContext.getAttribute("onlineNum");
        //为null则设置属性
        if (null == onlineNum) {
            onlineNum = new AtomicInteger(0);
            onlineNum.incrementAndGet();
            servletContext.setAttribute("onlineNum", onlineNum);
        } else {
            onlineNum.incrementAndGet();
        }
        System.out.println("当前在线人数：" + onlineNum.get());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed");
        // 上下文对象
        final ServletContext servletContext = se.getSession().getServletContext();
        final AtomicInteger onlineNum = (AtomicInteger) servletContext.getAttribute("onlineNum");
        System.out.println("剩余在线人数：" + onlineNum.decrementAndGet());
    }

}

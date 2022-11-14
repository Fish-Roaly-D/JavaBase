package com.roily.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Date: 2022/11/14/9:58
 * @Description:
 */
public class CookieApi extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有的cookie
        //首次获取浏览器缓存的cookies
        final Cookie[] cookies = req.getCookies();
        System.out.println("===================");
        for (Cookie cookie : cookies) {
            System.out.println("-----------");
            System.out.println("cookie name:" + cookie.getName());
            System.out.println("cookie value:" + URLDecoder.decode(cookie.getValue(), "utf-8"));
            System.out.println("-----------");
        }
        System.out.println("===================");

        //创建cookie，cookie的name一旦设置就不可变
        Cookie cookie = new Cookie("name", "value");
        //setValue()设置cookie或更新cookie值，如果是中文的话需要进行编码
        cookie.setValue(URLEncoder.encode("值", "utf-8"));

        //对cookie进行描述
        cookie.setComment("cookie描述字段");
        //设置可见域名，默认情况下cookie只对发送他们的服务器可见。本地测试就是localhost
        // cookie.setDomain("");

        //设置cookie的过期时间(以秒为单位)，如果不设置此cookie只在session会话中有效
        cookie.setMaxAge(60 * 60 * 24);

        //设置cookie对当前服务器那些路径可见，默认当前页
        cookie.setPath(req.getContextPath());

        resp.addCookie(cookie);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}

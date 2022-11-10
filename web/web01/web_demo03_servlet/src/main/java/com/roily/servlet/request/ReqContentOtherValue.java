package com.roily.servlet.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

/**
 * @Date: 2022/11/10/16:17
 * @Description:
 */
public class ReqContentOtherValue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        otherValue(req,resp);
    }


    private void otherValue(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("编码方式：" + req.getCharacterEncoding());
        System.out.println("请求内容类型：" + req.getContentType());
        System.out.println("本机ip地址：" + req.getLocalAddr());
        System.out.println("本机name：" + req.getLocalName());
        System.out.println("本机端口：" + req.getLocalPort());
        System.out.println("远程ip地址：" + req.getRemoteAddr());
        System.out.println("远程name：" + req.getRemoteUser());
        System.out.println("远程端口：" + req.getRemotePort());

        System.out.println("请求参数（跟在？后的字符串）：" + req.getQueryString());
        //指定路径用于请求转发
        final RequestDispatcher requestDispatcher = req.getRequestDispatcher("");
        //获取所有的Cookies，cookies存在于客户端（也就是浏览器）
        final Cookie[] cookies = req.getCookies();
        //获取session，session存在于服务端，所有客户端共享
        final HttpSession session = req.getSession();

    }


}

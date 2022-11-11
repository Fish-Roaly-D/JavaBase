package com.roily.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Date: 2022/11/11/17:46
 * @Description:
 */
public class ReqDispatcher extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String flag = req.getParameter("flag");
        System.out.println(flag);
        if ("1".equals(flag)) {
            dispatcherServlet(req, resp);
        } else {
            dispatcherStatic(req, resp);
        }
    }

    /**
     * 请求转发到静态页面
     *
     * @param req
     * @param resp
     */
    private void dispatcherStatic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/jsp/reqDispatcher.jsp").forward(req, resp);
    }

    /**
     * 请求转发到Servlet
     *
     * @param req
     * @param resp
     */
    private void dispatcherServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/reqDispatcherServlet").forward(req, resp);

    }


}

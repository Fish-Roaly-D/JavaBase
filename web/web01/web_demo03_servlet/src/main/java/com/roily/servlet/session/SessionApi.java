package com.roily.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Date: 2022/11/14/15:52
 * @Description:
 */
public class SessionApi extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("设置session");
        final String browser = req.getParameter("browser");

        final HttpSession session = req.getSession();
        session.setMaxInactiveInterval(100);
        session.setAttribute("browser", browser);
    }
}

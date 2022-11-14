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
public class SessionApiBrowserName extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("取session属性");
        final HttpSession session = req.getSession();

        System.out.println(session.getMaxInactiveInterval());
        System.out.println(session.getId());
        System.out.println(session.getAttribute("browser"));

    }
}

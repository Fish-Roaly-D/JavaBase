package com.roily.servlet.dispatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Date: 2022/10/24/10:32
 * @Description:
 */
public class Servlet01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("====1====getParameter===========");

        final Enumeration parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(req.getParameter((String) parameterNames.nextElement()));
        }
        System.out.println("====1====getParameter===========");

        System.out.println("====1====getAttribute===========");
        final Enumeration attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(req.getAttribute((String) attributeNames.nextElement()));
        }
        System.out.println("====1====getAttribute===========");
        req.setAttribute("add", "add");
        req.getRequestDispatcher("/servlet2").forward(req, resp);
    }
}

package com.roily.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Date: 2022/10/24/11:59
 * @Description:
 */
public class ResponseWriterDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final PrintWriter writer = resp.getWriter();
        writer.write("resp Writer");
        writer.write(97);
        writer.println();
        writer.println("resp Print");
        writer.println(97);
        writer.flush();
        writer.close();
        resp.setContentType("text/html");
        System.out.println(resp.getContentType());
    }

}

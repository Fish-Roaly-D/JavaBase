package com.roily.servlet.response;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Date: 2022/10/24/11:59
 * @Description:
 */
public class ResponseWriter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        respWriter(req, resp);

    }

    private static void respWriter(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //字符流
        // try (final PrintWriter writer = resp.getWriter();) {
        //     writer.write("resp Writer");
        //     writer.write(97);
        //     writer.println();
        //     writer.println("resp Print");
        //     writer.println(97);
        //     writer.flush();
        // }
        /**
         * 字节流
         * - 乱码问题，设置resp响应编码，或设置过滤器
         */
        //为响应设置字符编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        try (final ServletOutputStream outputStream = resp.getOutputStream();) {
            String str = "起飞!!!起飞!!!起飞!!!起飞!!!起飞!!!";
            final byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            outputStream.write(bytes);
            outputStream.flush();
        }

        /**
         * 字节流
         * - 乱码问题，设置resp响应编码，或设置过滤器
         */
        //为响应设置字符编码
        try (final ServletOutputStream outputStream = resp.getOutputStream();) {
            String str = "起飞!!!起飞!!!起飞!!!起飞!!!起飞!!!";
            final byte[] bytes = str.getBytes();
            outputStream.write(bytes);
            outputStream.flush();
        }
    }

    private static void respDate(HttpServletResponse resp) throws IOException {

        final ServletOutputStream outputStream = resp.getOutputStream();


    }

}

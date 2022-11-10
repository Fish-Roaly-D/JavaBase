package com.roily.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Date: 2022/11/10/14:33
 * @Description: requset对象作为请求对象，封装请求参数给到Servlet
 */
public class ReqAcceptReqParamAndAttributeForWard extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        reqAttribute(req, resp);


    }

    /**
     * req是一个容器，可以往里面放置属性
     *
     * @param req
     */
    private void reqAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Enumeration attributeNames = req.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            final String attributeName = (String) attributeNames.nextElement();
            final Object attribute = req.getAttribute(attributeName);
            if (String.class.isInstance(attribute))
                System.out.println("attributeName:" + attributeName + ", attributeValue:" + attribute);
            else
                System.out.println("attributeName:" + attributeName + ", attributeValue:" + attribute.toString());

        }
        req.removeAttribute("value1");


        System.out.println(req.getParameter("value"));
    }


}

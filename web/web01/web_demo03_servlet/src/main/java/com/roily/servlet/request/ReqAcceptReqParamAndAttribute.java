package com.roily.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Date: 2022/11/10/14:33
 * @Description: requset对象作为请求对象，封装请求参数给到Servlet
 */
public class ReqAcceptReqParamAndAttribute extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getClass().getName());
        reqParam(req);
        reqAttribute(req, resp);

    }

    /**
     * req是一个容器，可以往里面放置属性
     *
     * @param req
     */
    private void reqAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //手动设置attribute，请求转发传递request，因为req生命周期只在一个请求期间

        req.setAttribute("key1", "value1");
        req.setAttribute("key1", "value1X");
        req.setAttribute("key2", "value2");
        req.setAttribute("key3", "value3");
        req.getRequestDispatcher("/reqAcceptReqParamAndAttributeForWard").forward(req, resp);
    }


    /**
     * req 获取请求参数
     * - 获取所有请求参数
     * - 根据请求参数key获取value，存在同名返回第一个
     * - 根据请求参数key获取所有请求参数的value  这是一个集合，请求参数的key允许重复
     * - 将请求参数作为map，value为一个集合对象
     *
     * @param req
     */
    private void reqParam(HttpServletRequest req) {
        System.out.println("====getParameterNames()====");
        final Enumeration parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            final String paramKey = (String) parameterNames.nextElement();
            final String paramValue = req.getParameter(paramKey);
            System.out.println("Key:" + paramKey + "," + "Value:" + paramValue);
        }
        System.out.println("====getParameterValues()====");

        //可以存在同名的key，通过此方法可以获取所有此key的value
        final String[] values = req.getParameterValues("value");
        final StringBuilder sb = new StringBuilder("key:value:");
        for (String value : values) {
            sb.append(value + ",");
        }
        System.out.println(sb.toString());

        System.out.println("====getParameterMap()====");
        //返回 javax.parameterMap<String,Object[]>
        final Map<String, Object> parameterMap = req.getParameterMap();
        parameterMap.entrySet().forEach(entity -> {
            final Object value = entity.getValue();
            if (String[].class.isInstance(value)) {
                String[] strings = (String[]) value;
                final StringBuilder sb2 = new StringBuilder("key:" + entity.getKey() + ":");
                for (String string : strings) {
                    sb2.append(string + ",");
                }
                System.out.println(sb2.toString());
            }
        });
    }

}

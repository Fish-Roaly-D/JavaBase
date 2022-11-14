package com.roily.servlet.filtert;

import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @classname：FilterBwkFilter
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/15 00:07
 */
public class FilterBwkFilter implements Filter {

    private final List<String> keyWorlds = Arrays.asList("草", "fuck", "鸡");

    private String replaceChar = "*";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterBwkFilter 敏感词汇过滤器 初始化");
    }

    /**
     * @param request  拦截得到的请求对象
     * @param response 拦截servlet返回的响应对象
     * @param chain    调用 chain.doFilter(request, response);进行放行，给下一个过滤器或给到servlet
     * @throws IOException
     * @throws ServletException
     */
    @lombok.SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器前置操作");
        String keyWorld = request.getParameter("keyWorld");
        if (!StringUtils.isEmpty(keyWorld)) {
            for (String world : keyWorlds) {
                String xx = keyWorld.replace(world, "***");
                final Field value = keyWorld.getClass().getDeclaredField("value");
                value.setAccessible(true);
                value.set(keyWorld, xx.toCharArray());
            }
        }
        chain.doFilter(request, response);
        System.out.println("过滤器后置操作");
    }

    @Override
    public void destroy() {
        System.out.println("FilterBwkFilter 敏感词汇过滤器 销毁，一般跟随web容器");

    }
}

package com.roly.redisresolve.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.roly.redisresolve.common.util.SysConstants.USER_SESSION_KEY;

/**
 * @Date: 2023/02/27/9:52
 * @Description:登录拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 1.拿到Session
        final HttpSession session = request.getSession();
        // 2.拿到用户数据
        final Object userDto = session.getAttribute(USER_SESSION_KEY);
        // 3.判断userDto是否存在
        if (null == userDto){
            // 3.1 为空则拦截
            response.setStatus(401);
            return false;
        }
        // 3.2 不为空则放行
        return true;
    }

}

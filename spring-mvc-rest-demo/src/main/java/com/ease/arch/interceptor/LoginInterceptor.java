package com.ease.arch.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return super.preHandle(request, response, handler);
        //模拟某一种校验逻辑
        String key = "";
        String value = "";
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            response.setStatus(401);
            response.getWriter().write("校验未通过");
            return false;
        }
        for (Cookie cookie : cookies) {
            if ("name".equals(cookie.getName())) {
                key = cookie.getName();
                value = cookie.getValue();
            }
        }
        if (!value.equals("")) {
            return true;
        }
        response.setStatus(401);
        response.getWriter().write("校验未通过");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("finish controller");
    }
}

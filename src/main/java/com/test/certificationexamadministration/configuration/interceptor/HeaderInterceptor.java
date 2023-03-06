package com.test.certificationexamadministration.configuration.interceptor;

import com.test.certificationexamadministration.controller.UrlMappings;
import com.test.certificationexamadministration.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderInterceptor implements HandlerInterceptor {
    private final JwtUtil jwtUtil;

    @Autowired
    public HeaderInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().contains(UrlMappings.AUTH_URL)) {
            return true;
        }

        return jwtUtil.validateToken(request.getHeader("token"));
    }
}

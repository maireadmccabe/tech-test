package com.sojern.techtest.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class InterceptRequest implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger("InterceptRequest");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        logger.info("Request Intercepted {}: {}", request.getMethod(), request.getServletPath());
        return true;
    }
}

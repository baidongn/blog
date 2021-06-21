package com.bolg.blog_security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 17:13 2021/6/21
 */
public interface MyService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}

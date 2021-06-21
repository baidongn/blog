package com.bolg.blog_security.handle;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 13:48 2021/6/21
 */
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    private String url;

    public MyAuthenticationFailHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.sendRedirect(url);

    }
}

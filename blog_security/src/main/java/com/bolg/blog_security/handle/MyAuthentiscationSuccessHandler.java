package com.bolg.blog_security.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 13:31 2021/6/21
 */
public class MyAuthentiscationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyAuthentiscationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        //其实就是一个user对象
        User user = (User)authentication.getPrincipal();
        System.out.println(user.getUsername());
        //考虑到安全，密码不会直接打印出来，会打印成为null
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());

        httpServletResponse.sendRedirect(url);


    }
}

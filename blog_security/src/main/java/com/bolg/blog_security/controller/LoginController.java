package com.bolg.blog_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 17:41 2021/6/19
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() {
        System.out.println("执行登录方法");
        return "redirect:main.html";
    }


}

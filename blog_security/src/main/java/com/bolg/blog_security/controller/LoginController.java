package com.bolg.blog_security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 17:41 2021/6/19
 */
@Controller
public class LoginController {

    //用不到（/login  并不会走这里的逻辑，而是有默认的框架逻辑）
//    @RequestMapping("login")
//    public String login() {
//        System.out.println("执行登录方法");
//        return "redirect:main.html";
//    }

//    @Secured("ROLE_abc")  //必须要有ROLE_。可以在service和controlelr上使用
    @PreAuthorize("hasRole('abc')")//这里也可以ROLE_开头
    @RequestMapping("toMain")
    public String toMain() {
        return "redirect:main.html";
    }


    @RequestMapping("toError")
    public String toError() {
        return "redirect:error.html";
    }


    @GetMapping("demo")
    @ResponseBody
    public String demo() {
        return "demo";
    }

}

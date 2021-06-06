package com.blog.blogDataAssets.controller.admin;


import com.blog.blogApiCommons.utils.JSONResult;
import com.blog.blogDataAssets.po.User;
import com.blog.blogDataAssets.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JSONResult login(@RequestParam String username,
                            @RequestParam String password) {
        User user = userService.checkUser(username, password);
        return JSONResult.success(user);
    }

}

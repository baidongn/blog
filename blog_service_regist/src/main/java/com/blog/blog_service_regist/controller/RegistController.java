package com.blog.blog_service_regist.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 15:11 2021/6/2
 */

@RestController
@RefreshScope//实现配置自动更新
public class RegistController {


    @Value("${server.port}")
    private String serverPort;
//    @Value("${blog.name}")
//    private String blogName;

    @GetMapping(value = "/getregist/get/{id}")
    public String getPaymentById(@PathVariable("id") Long id) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return "success："+serverPort;
    }
}

package com.blog.blog_service_regist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//开启服务注册发现功能
public class BlogServiceRegistApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServiceRegistApplication.class, args);
    }

}

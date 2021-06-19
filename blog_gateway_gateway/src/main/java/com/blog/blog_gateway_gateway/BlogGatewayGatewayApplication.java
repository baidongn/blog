package com.blog.blog_gateway_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient
public class BlogGatewayGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogGatewayGatewayApplication.class, args);
    }

}

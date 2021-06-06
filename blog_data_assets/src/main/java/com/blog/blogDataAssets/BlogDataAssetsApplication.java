package com.blog.blogDataAssets;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.blog.blogDataAssets.mapper")
@SpringBootApplication
public class BlogDataAssetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogDataAssetsApplication.class, args);
    }

}

package com.blog.blog_gateway_gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

//@SpringBootTest
class BlogGatewayGatewayApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

}

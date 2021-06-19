package com.blog.blog_gateway_gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.Arrays;

//@SpringBootTest
class BlogGatewayGatewayApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    public static void main(String[] args) {

        String a = "1,2,3,4,5,6";

        String[] split = a.split(",");

        System.out.println(Arrays.asList(split));

    }

}

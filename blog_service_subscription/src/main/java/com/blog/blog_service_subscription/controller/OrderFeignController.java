package com.blog.blog_service_subscription.controller;

import com.blog.blog_service_subscription.service.PaymentFeignService;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 15:14 2021/6/2
 */
@RestController
public class OrderFeignController {


    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping(value = "/sub/getregist/nacos/{id}")
    public String getRegist(@PathVariable("id") Integer id){
        return paymentFeignService.getRegist(id);
    }
}

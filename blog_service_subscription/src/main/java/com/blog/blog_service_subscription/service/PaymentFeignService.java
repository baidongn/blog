package com.blog.blog_service_subscription.service;

import com.blog.blog_service_subscription.exception.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 15:10 2021/6/2
 */

@Component
@FeignClient(value = "regist")
public interface PaymentFeignService {

    @GetMapping(value = "/getregist/get/{id}")
    public String getRegist(@PathVariable("id") Integer id);
}

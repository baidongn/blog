package com.blog.blog_service_subscription.exception;

import com.blog.blog_service_subscription.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 17:00 2021/6/2
 */
@Component
public class PaymentFallbackService  implements PaymentFeignService {

    @Override
    public String getRegist(Integer id) {
        return "服务降级返回,---PaymentFallbackService";
    }
}

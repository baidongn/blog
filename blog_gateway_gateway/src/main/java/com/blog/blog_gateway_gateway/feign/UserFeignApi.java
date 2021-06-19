package com.blog.blog_gateway_gateway.feign;

import com.blog.blog_gateway_gateway.moudle.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 14:07 2021/6/18
 */
@Component
@FeignClient(value = "data_assets")
public interface UserFeignApi {
    @PostMapping("/getUser")
    User getUserByName(@RequestParam(value = "username") String username);
}

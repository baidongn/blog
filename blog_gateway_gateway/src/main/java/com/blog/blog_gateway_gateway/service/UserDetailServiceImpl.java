package com.blog.blog_gateway_gateway.service;

import com.blog.blog_gateway_gateway.feign.UserFeignApi;
import com.blog.blog_gateway_gateway.moudle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： bd
 * @Description:  授权
 * @Date: Created in 12:53 2021/6/19
 */
@Component
public class UserDetailServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    private UserFeignApi userFeignApi;


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        /*定义权限集合*/
        List<GrantedAuthority> authority = new ArrayList<>();
        SimpleGrantedAuthority role_seller = new SimpleGrantedAuthority("ROLE_USER");
        authority.add(role_seller);
        if (username == null) {
            return null;
        }
        User user = userFeignApi.getUserByName(username);
        if (user != null) {
            if (user.getUsername().equals(username)) {
                UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles("USER")
                        .build();
                return Mono.just(userDetails);
            }
        }
        return Mono.error(new UsernameNotFoundException("User Not Found"));

    }
}

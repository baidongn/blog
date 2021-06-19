package com.bolg.blog_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.net.PasswordAuthentication;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 17:26 2021/6/19
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //表单提交
        http.formLogin()
                //当发现/login时认为是登陆，必须和表单提交的地址一样，去执行
                .loginProcessingUrl("/login")
                //自定义登陆页
                .loginPage("/login.html");


        //授权认证
        http.authorizeRequests()
                ///login.html 不需要认证
                .antMatchers("/login.html").permitAll()
                //所有请求都会被认证，必须登陆之后再访问
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();
    }

    /**
     * 选择一个PasswordEncoder的实现类
     *
     * @return
     */
    @Bean
    public PasswordEncoder getPw() {
        return new BCryptPasswordEncoder();
    }
}

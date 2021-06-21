package com.bolg.blog_security.config;

import com.bolg.blog_security.handle.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 17:26 2021/6/19
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //表单提交
        http.formLogin()
                //修改username和password传入参数名称（一定要和表单别名配对）
                .usernameParameter("username123")
                .passwordParameter("password123")
                //当发现/login时认为是登陆，必须和表单提交的地址一样，去执行UserDetailsServiceImpl（应该是框架默认/login就会走UserDetailsServiceImpl的实现）
                .loginProcessingUrl("/login")
                //自定义登陆页
                .loginPage("/login.html")
//                //登陆成功后跳转页面，post请求；  点进去查看源码得知，只要实现了AuthenticationSuccessHandler就可以
                .successForwardUrl("/toMain")
                //登陆成功后的处理器，不能和successForwardUrl共存
//                .successHandler(new MyAuthentiscationSuccessHandler("https://www.baidu.com"))
//                //登录失败后跳转页面，post请求
                .failureForwardUrl("/toError")
                //登陆失败后的处理器，不能和failureForwardUrl共存（直接进行跳转，不用通过 controller 进行转发x）
//                .failureHandler(new MyAuthenticationFailHandler("/error.html"))


        ;


        //授权认证
        http.authorizeRequests()
                //error.html  不需要被认证
//                .antMatchers("/error.html").permitAll()
                .antMatchers("/error.html").access("permitAll()")//access表达式用法
                ///login.html 不需要认证
                .antMatchers("/login.html").permitAll()
                //放行静态资源
//                .antMatchers("/js/**","/css/**","/images/**").permitAll()
                //所有目录下 *.png都会被放行
//                .antMatchers("/**/*.png").permitAll()
                //正则表达式： . 任意，[.]转义.  jpg
//                .regexMatchers(".+[.]jpg").permitAll()
                //请求方式   请求路径
//                .regexMatchers(HttpMethod.POST,"/demo").permitAll()
                // application yml加的spring.mvc.servletPath
//                .mvcMatchers("/demo").servletPath("/security").permitAll()
//                .mvcMatchers("/security/demo").permitAll()

                //权限
//                .antMatchers("/main1.html").hasAnyAuthority("admi") //权限，严格区分大小写
//                .antMatchers("/main1.html").hasAnyAuthority("admin","adminN")

                //角色
//                .antMatchers("/main1.html").hasAnyRole("abc","qwe") //不需要ROLE_，严格区分大小写
                .antMatchers("/main1.html").access("hasRole('abc')") //access表达式用法
//                .antMatchers("/main1.html").hasIpAddress("127.0.0.1")

                //所有请求都会被认证，必须登陆之后再访问
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();

        //异常处理
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);

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

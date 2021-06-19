package com.blog.blog_gateway_gateway.filter;

import com.blog.blog_gateway_gateway.service.UserDetailServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 13:00 2021/6/19
 */

//自定义全局过滤器
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class TokenGlobalFilter implements GlobalFilter {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    private static final String AUTHORIZE_TOKEN = "token";

    @Override
    //执行过滤器逻辑
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("执行过滤器逻辑");
        String token = exchange.getRequest().getHeaders().getFirst(AUTHORIZE_TOKEN);
        System.out.println(token);
        if (!StringUtils.isEmpty(token)) {//判断token是否为空
            Claims claims = Jwts.parser().setSigningKey("")
                    .parseClaimsJws(token)
                    .getBody();
            String userName = (String) claims.get("userName");

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {//判断Security的用户认证信息
                Mono<UserDetails> byUsername = userDetailService.findByUsername(userName);
                // 将用户信息存入 authentication，方便后续校验
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(byUsername.block(), null, byUsername.block().getAuthorities());
                authentication.setDetails(byUsername.block());
                // 将 authentication 存入 ThreadLocal，方便后续获取用户信息
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        //放行
        return chain.filter(exchange);
    }




}

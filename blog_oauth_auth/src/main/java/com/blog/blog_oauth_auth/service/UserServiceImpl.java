package com.blog.blog_oauth_auth.service;

import com.blog.blog_oauth_auth.feign.UserFeignApi;
import com.blog.blog_oauth_auth.moudle.OauthUser;
import com.blog.blog_oauth_auth.moudle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author： bd
 * @Description:
 * @Date: Created in 13:40 2021/6/18
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserFeignApi userFeignApi;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userFeignApi.getUserByName(userName);
        if (user != null) {
            org.springframework.security.core.userdetails.User userinfo = new org.springframework.security.core.userdetails.User(user.getNickname(), user.getPassword(), AuthorityUtils.createAuthorityList("admin"));
            return new OauthUser(user, userinfo);
        } else {
            throw new UsernameNotFoundException("用户[" + userName + "]不存在");
        }
    }
}

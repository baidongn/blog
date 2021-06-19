package com.blog.blogDataAssets.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogDataAssets.mapper.UserMapper;
import com.blog.blogDataAssets.po.User;
import com.blog.blogDataAssets.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
@Service()
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User checkUser(String username, String password) {

        User user = this.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username).eq(User::getPassword, password));

        return user;
    }

    @Override
    public User getUserByName(String username) {
        User user = this.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        return user;
    }
}

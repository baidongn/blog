package com.blog.blogDataAssets.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogDataAssets.po.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
public interface UserService extends IService<User> {
    //核对用户名和密码
    User checkUser(String username, String password);
}

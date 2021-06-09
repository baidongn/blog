package com.blog.blogDataAssets.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.moudle.dto.FriendDTO;
import com.blog.blogDataAssets.po.Friend;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
public interface FriendService extends IService<Friend> {
    //查询所有友链
    Page<FriendDTO> listFriendLink(PageDTO pageDTO);

    //友链新增
    boolean saveFriendLink(FriendDTO friendDTO);

    //根据网址查询友链
    FriendDTO getFriendLinkByBlogaddress(String blogaddress);

    //根据id查询友链
    FriendDTO getFriendLink(Long id);

    //编辑修改友链
    boolean updateFriendLink(FriendDTO friendDTO);

    //删除友链
    boolean deleteFriendLink(Long id);

}

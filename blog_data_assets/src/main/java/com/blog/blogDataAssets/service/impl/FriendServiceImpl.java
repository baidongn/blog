package com.blog.blogDataAssets.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.mapper.FriendMapper;
import com.blog.blogDataAssets.moudle.dto.FriendDTO;
import com.blog.blogDataAssets.po.Friend;
import com.blog.blogDataAssets.service.FriendService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

    @Override
    public Page<FriendDTO> listFriendLink(PageDTO pageDTO) {
        IPage<Friend> page = new Page<>(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        IPage<Friend> friendPage = this.page(page);
        List<FriendDTO> friendDTOS = friendPage.getRecords().stream().map(s -> {
            FriendDTO friendDTO = new FriendDTO();
            BeanUtils.copyProperties(s, friendDTO);
            return friendDTO;
        }).collect(Collectors.toList());
        Page friendVOpage = new Page(friendPage.getCurrent(), friendPage.getSize(), friendPage.getTotal());
        friendVOpage.setRecords(friendDTOS);
        return friendVOpage;
    }

    @Override
    public boolean saveFriendLink(FriendDTO friendDTO) {
        Friend friend = new Friend();
        BeanUtils.copyProperties(friend, friendDTO);
        return this.save(friend);

    }

    @Override
    public FriendDTO getFriendLinkByBlogaddress(String blogaddress) {
        FriendDTO friendDTO = new FriendDTO();
        Friend friend = this.getOne(new LambdaQueryWrapper<Friend>().eq(Friend::getBlogaddress, blogaddress));
        BeanUtils.copyProperties(friend, friendDTO);
        return friendDTO;
    }

    @Override
    public FriendDTO getFriendLink(Long id) {
        FriendDTO friendDTO = new FriendDTO();
        Friend friend = this.getById(id);
        BeanUtils.copyProperties(friend, friendDTO);
        return friendDTO;
    }

    @Override
    public boolean updateFriendLink(FriendDTO friendDTO) {

        Friend friend = new Friend();
        BeanUtils.copyProperties(friendDTO, friend);
        return this.update(friend, new LambdaQueryWrapper<Friend>().eq(Friend::getId, friend.getId()));
    }

    @Override
    public boolean deleteFriendLink(Long id) {
        return this.removeById(id);

    }
}

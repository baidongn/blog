package com.blog.blogDataAssets.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blogApiCommons.utils.JSONResult;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.moudle.dto.FriendDTO;
import com.blog.blogDataAssets.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin")
public class FriendController {
    @Autowired
    private FriendService friendLinkService;

    //查询所有友链
    @GetMapping("/friendlinks")
    public JSONResult friend(@RequestBody PageDTO pageDTO) {
        Page<FriendDTO> friendDTOPage = friendLinkService.listFriendLink(pageDTO);
        return JSONResult.success(friendDTOPage);
    }

    //友链新增
    @PostMapping("/friendlinks")
    public JSONResult post(@RequestBody FriendDTO friendLink) {

        FriendDTO friend = friendLinkService.getFriendLinkByBlogaddress(friendLink.getBlogaddress());
        if (friend != null) {
            return JSONResult.errorMsg("该友链接存在");
        }
        friendLink.setCreateTime(LocalDateTime.now());
        return friendLinkService.saveFriendLink(friendLink) ? JSONResult.success() : JSONResult.errorMsg("新增失败");

    }


    //编辑修改友链
    @PostMapping("/friendlinks/{id}")
    public JSONResult editPost(@RequestBody FriendDTO friendDTO) {
        return friendLinkService.updateFriendLink(friendDTO) ? JSONResult.success() : JSONResult.errorMsg("修改失败");

    }

    //删除友链
    @GetMapping("/friendlinks/{id}/delete")
    public JSONResult delete(@PathVariable Long id) {
        friendLinkService.deleteFriendLink(id);
        return JSONResult.success();
    }


}

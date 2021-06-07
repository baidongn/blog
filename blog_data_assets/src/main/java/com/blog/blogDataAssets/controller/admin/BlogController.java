package com.blog.blogDataAssets.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blogApiCommons.utils.JSONResult;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.moudle.vo.BlogVO;
import com.blog.blogDataAssets.po.Blog;
import com.blog.blogDataAssets.service.BlogService;
import com.blog.blogDataAssets.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;

    //博客新增
    @PostMapping("/blogs")
    public JSONResult post(@RequestBody Blog blog) {
        //设置blog中typeId属性
        blog.setTypeId(blog.getTypeId());
        //设置用户id
        blog.setUserId(blog.getUserId());

        blogService.saveBlog(blog);
        return JSONResult.success();
    }

    //博客列表
    @RequestMapping("/blogs")
    public Page<BlogVO> blogs(@RequestBody PageDTO pageDTO) {
        Page<BlogVO> allBlog = blogService.getAllBlog(pageDTO);
        return allBlog;
    }

}

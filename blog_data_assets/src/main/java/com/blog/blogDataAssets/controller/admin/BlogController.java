package com.blog.blogDataAssets.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blogApiCommons.utils.JSONResult;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.moudle.dto.BlogDTO;
import com.blog.blogDataAssets.moudle.dto.SearchDTO;
import com.blog.blogDataAssets.moudle.vo.BlogVO;
import com.blog.blogDataAssets.po.Blog;
import com.blog.blogDataAssets.service.BlogService;
import com.blog.blogDataAssets.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public JSONResult blogs(@RequestBody PageDTO pageDTO) {
        Page<BlogVO> allBlog = blogService.getAllBlog(pageDTO);
        return JSONResult.success(allBlog);
    }

    //删除博客
    @GetMapping("/blogs/{id}/delete")
    public JSONResult delete(@PathVariable Long id, RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        return JSONResult.success();
    }

    //跳转编辑修改文章
    @GetMapping("/blogs/{id}/input")
    public JSONResult editInput(@PathVariable Long id) {
        BlogDTO blogById = blogService.getBlogById(id);

        return JSONResult.success(blogById);
    }

    //编辑修改文章
    @PostMapping("/blogs")
    public JSONResult editPost(@Valid @RequestBody BlogDTO blogDTO) {
        return blogService.updateBlog(blogDTO) ? JSONResult.success() : JSONResult.errorMsg("更新失败");
    }

    //搜索博客管理列表
    @PostMapping("/blogs/search")
    public JSONResult search(@RequestBody PageDTO<SearchDTO> pageDTO) {
        return JSONResult.success(blogService.getBlogBySearch(pageDTO));

    }

}

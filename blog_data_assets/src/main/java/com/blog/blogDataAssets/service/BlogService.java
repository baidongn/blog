package com.blog.blogDataAssets.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.moudle.dto.BlogDTO;
import com.blog.blogDataAssets.moudle.dto.SearchDTO;
import com.blog.blogDataAssets.moudle.vo.BlogVO;
import com.blog.blogDataAssets.po.Blog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
public interface BlogService extends IService<Blog> {

    //保存新增博客
    boolean saveBlog(Blog blog);

    //查询文章管理列表
    Page<BlogVO>  getAllBlog(PageDTO pageDTO);

    //删除博客
    void deleteBlog(Long id);

    //查询编辑修改的文章
    BlogDTO getBlogById(Long id);

    //编辑修改文章
    boolean updateBlog(BlogDTO showBlog);

    //搜索博客管理列表
    Page<BlogVO>  getBlogBySearch(PageDTO<SearchDTO> pageDTO);

}

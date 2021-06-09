package com.blog.blogDataAssets.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.mapper.BlogMapper;
import com.blog.blogDataAssets.moudle.dto.BlogDTO;
import com.blog.blogDataAssets.moudle.dto.SearchDTO;
import com.blog.blogDataAssets.moudle.vo.BlogVO;
import com.blog.blogDataAssets.po.Blog;
import com.blog.blogDataAssets.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    //保存新增博客
    @Override
    public boolean saveBlog(Blog blog) {
        blog.setCreateTime(LocalDateTime.now());
        blog.setUpdateTime(LocalDateTime.now());
        blog.setViews(0);
        blog.setCommentCount(0);
        return this.save(blog);
    }

    //查询文章管理列表
    @Override
    public Page<BlogVO> getAllBlog(PageDTO pageDTO) {
        IPage<Blog> page = new Page<>(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        Page<Blog> blogPage = (Page<Blog>) this.page(page, new LambdaQueryWrapper<Blog>().orderByDesc(Blog::getUpdateTime));

        List<BlogVO> blogVOS = blogPage.getRecords().stream().map(s -> {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(s, blogVO);
            return blogVO;
        }).collect(Collectors.toList());
        Page blogVOpage = new Page(blogPage.getCurrent(), blogPage.getSize(), blogPage.getTotal());
        blogVOpage.setRecords(blogVOS);
        return blogVOpage;
    }

    @Override
    public void deleteBlog(Long id) {
        this.removeById(id);
    }

    @Override
    public BlogDTO getBlogById(Long id) {
        BlogDTO blogDTO = new BlogDTO();
        Blog blog = this.getById(id);
        BeanUtils.copyProperties(blog, blogDTO);
        return blogDTO;
    }

    @Override
    public boolean updateBlog(BlogDTO showBlog) {
        Blog blog = new Blog();
        showBlog.setUpdateTime(LocalDate.now());
        BeanUtils.copyProperties(showBlog, blog);
        return this.update(blog, new LambdaUpdateWrapper<Blog>().eq(Blog::getId, showBlog.getId()));

    }

    @Override
    public Page<BlogVO> getBlogBySearch(PageDTO<SearchDTO> pageDTO) {
        SearchDTO searchBlog = pageDTO.getCheckDto();
        IPage<Blog> page = new Page<>(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        IPage<Blog> blogPage = this.page(page, new LambdaQueryWrapper<Blog>().eq(Blog::getTypeId, searchBlog.getTypeId()).like(Blog::getTitle, searchBlog.getTitle()));
        List<BlogVO> blogVOS = blogPage.getRecords().stream().map(s -> {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(s, blogVO);
            return blogVO;
        }).collect(Collectors.toList());
        Page blogVOpage = new Page(blogPage.getCurrent(), blogPage.getSize(), blogPage.getTotal());
        blogVOpage.setRecords(blogVOS);
        return blogVOpage;
    }
}

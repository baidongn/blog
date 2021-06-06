package com.blog.blogDataAssets.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogDataAssets.mapper.BlogMapper;
import com.blog.blogDataAssets.po.Blog;
import com.blog.blogDataAssets.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}

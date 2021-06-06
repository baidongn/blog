package com.blog.blogDataAssets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogDataAssets.mapper.CommentMapper;
import com.blog.blogDataAssets.po.Comment;
import com.blog.blogDataAssets.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}

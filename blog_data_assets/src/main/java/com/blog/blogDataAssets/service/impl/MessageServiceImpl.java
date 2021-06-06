package com.blog.blogDataAssets.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogDataAssets.mapper.MessageMapper;
import com.blog.blogDataAssets.po.Message;
import com.blog.blogDataAssets.service.MessageService;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}

package com.blog.blogDataAssets.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogDataAssets.mapper.TypeMapper;
import com.blog.blogDataAssets.po.Type;
import com.blog.blogDataAssets.service.TypeService;
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
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}

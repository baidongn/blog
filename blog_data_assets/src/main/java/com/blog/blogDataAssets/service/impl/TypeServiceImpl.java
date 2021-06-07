package com.blog.blogDataAssets.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.mapper.TypeMapper;
import com.blog.blogDataAssets.po.Type;
import com.blog.blogDataAssets.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {


    @Override
    public boolean saveType(Type type) {
        return this.save(type);
    }

    @Override
    public Type getType(Long id) {
        return this.getOne(new LambdaQueryWrapper<Type>().eq(Type::getId, id));
    }

    @Override
    public Page<Type> getAllType(PageDTO  pageDTO) {
        IPage<Type> page = new Page<>(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        Page<Type> typePage = (Page<Type>) this.page(page, new LambdaQueryWrapper<Type>().orderByDesc(Type::getId));
        return typePage;
    }

    @Override
    public Type getTypeByName(String name) {
        return this.getOne(new LambdaQueryWrapper<Type>().eq(Type::getName, name));
    }

    @Override
    public boolean updateType(Type type) {
        return this.update(type, new LambdaUpdateWrapper<Type>().eq(Type::getId, type.getId()));
    }

    @Override
    public void deleteType(Long id) {
        this.deleteType(id);
    }
}

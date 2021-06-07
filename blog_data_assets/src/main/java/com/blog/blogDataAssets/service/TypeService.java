package com.blog.blogDataAssets.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.po.Type;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
public interface TypeService extends IService<Type> {

    //新增保存分类
    boolean saveType(Type type);

    //根据id查询分类
    Type getType(Long id);

    //查询所有分类
    Page<Type> getAllType(PageDTO pageDTO);

    //根据分类名称查询分类
    Type getTypeByName(String name);

    //编辑修改分类
    boolean updateType(Type type);

    //删除分类
    void deleteType(Long id);
}

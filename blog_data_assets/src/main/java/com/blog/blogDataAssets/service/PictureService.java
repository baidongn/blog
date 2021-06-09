package com.blog.blogDataAssets.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.po.Picture;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
public interface PictureService extends IService<Picture> {
    //查询照片
    Page<Picture> listPicture(PageDTO pageDTO);

    //添加图片
    boolean savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

    //编辑修改相册
    boolean updatePicture(Picture picture);

    //删除照片
    boolean deletePicture(Long id);
}

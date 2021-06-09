package com.blog.blogDataAssets.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.mapper.PictureMapper;
import com.blog.blogDataAssets.po.Picture;
import com.blog.blogDataAssets.service.PictureService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
@Service
public class PictureServiceImpl extends ServiceImpl<PictureMapper, Picture> implements PictureService {

    @Override
    public Page<Picture> listPicture(PageDTO pageDTO) {
        IPage<Picture> page = new Page<>(pageDTO.getCurrentPage(), pageDTO.getPageSize());
        Page<Picture> friendPage = (Page) this.page(page);
        return friendPage;

    }

    @Override
    public boolean savePicture(Picture picture) {
        return this.save(picture);
    }

    @Override
    public Picture getPicture(Long id) {
        return this.getById(id);
    }

    @Override
    public boolean updatePicture(Picture picture) {
        return this.update(picture, new LambdaQueryWrapper<Picture>().eq(Picture::getId, picture.getId()));

    }

    @Override
    public boolean deletePicture(Long id) {
        return this.removeById(id);
    }
}

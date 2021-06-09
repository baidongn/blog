package com.blog.blogDataAssets.controller.admin;


import com.blog.blogApiCommons.utils.JSONResult;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.po.Picture;
import com.blog.blogDataAssets.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class PictureController {


    @Autowired
    private PictureService pictureService;

    //    查询照片列表
    @GetMapping("/pictures")
    public JSONResult pictures(@RequestBody PageDTO pageDTO) {
        return JSONResult.success(pictureService.listPicture(pageDTO));

    }

    //    照片新增
    @PostMapping("/pictures")
    public JSONResult post(@RequestBody Picture picture) {

        return pictureService.savePicture(picture) ? JSONResult.success() : JSONResult.errorMsg("添加失敗");

    }

    //    编辑相册
    @PostMapping("/pictures/{id}")
    public JSONResult editPost(@Valid Picture picture, RedirectAttributes attributes) {

        return pictureService.updatePicture(picture) ? JSONResult.success() : JSONResult.errorMsg("編輯失敗");


    }

    //    删除照片
    @GetMapping("/pictures/{id}/delete")
    public JSONResult delete(@PathVariable Long id, RedirectAttributes attributes) {
        pictureService.deletePicture(id);
        return JSONResult.success();
    }

}

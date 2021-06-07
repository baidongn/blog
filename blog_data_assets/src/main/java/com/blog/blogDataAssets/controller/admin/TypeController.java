package com.blog.blogDataAssets.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blogApiCommons.utils.JSONResult;
import com.blog.blogApiCommons.utils.PageDTO;
import com.blog.blogDataAssets.po.Type;
import com.blog.blogDataAssets.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //    分页查询分类列表
    @GetMapping("/types")
    public JSONResult<Page<Type>> list(@RequestBody PageDTO pageDTO) {
        //按照排序字段 倒序 排序
        Page<Type> typePage = typeService.getAllType(pageDTO);
        return JSONResult.success(typePage);
    }

    //  新增分类
    @PostMapping("/types")
    public JSONResult post(@RequestBody Type type) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            return JSONResult.errorMsg("不要添加重复的类别");
        }
        typeService.saveType(type);
        return JSONResult.success();
    }

    //    编辑修改分类
    @PostMapping("/types/{id}")
    public JSONResult editPost(@RequestBody Type type) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            return JSONResult.errorMsg("不要添加重复的类别");
        }
        typeService.updateType(type);
        return JSONResult.success();
    }

    //    删除分类
    @GetMapping("/types/{id}/delete")
    public JSONResult delete(@PathVariable Long id) {
        typeService.deleteType(id);
        return JSONResult.success();
    }


}

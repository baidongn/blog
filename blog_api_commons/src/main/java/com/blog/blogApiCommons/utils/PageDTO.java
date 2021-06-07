package com.blog.blogApiCommons.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author : haibo
 * @description :
 * @date : 2020/12/31 13:58
 * @since : 1.0
 */
@Data
@ApiModel(value="分页", description="分页")
public class PageDTO<T> {
    @ApiModelProperty(value = "当前页数，默认第一页")
    private int currentPage = 1;

    @ApiModelProperty(value = "每页显示条数")
    public int pageSize = 10;

    @ApiModelProperty(value = "筛选条件")
    private T checkDto;

    /**
     * 获取分页Page
     * @return
     */
    @ApiModelProperty(hidden = true)
    public Page getPage () {
        return new Page(this.currentPage, this.pageSize);
    }

}
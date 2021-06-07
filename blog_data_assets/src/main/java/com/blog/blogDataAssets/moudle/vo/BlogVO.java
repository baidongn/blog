package com.blog.blogDataAssets.moudle.vo;

import com.blog.blogDataAssets.po.Type;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BlogVO {
    private Long id;
    private String title;
    private LocalDate updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;

}

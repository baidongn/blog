package com.blog.blogDataAssets.moudle.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BlogDTO {

    private Long id;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean published;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentabled;
    private LocalDate updateTime;

}

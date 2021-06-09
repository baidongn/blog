package com.blog.blogDataAssets.moudle.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FriendDTO {
    private Long id;

    private String blogaddress;

    private String blogname;

    private LocalDateTime createTime;

    private String pictureaddress;
}

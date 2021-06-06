package com.blog.blogDataAssets.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_blog")
public class Blog extends Model<Blog> {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Boolean appreciation;

    private Boolean commentabled;

    private String content;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String description;

    private String firstPicture;

    private String flag;

    private Boolean published;

    private Boolean recommend;

    private Boolean shareStatement;

    private String title;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private Integer views;

    private Long typeId;

    private Long userId;

    private Integer commentCount;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

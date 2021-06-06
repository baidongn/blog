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
@TableName("t_comment")
public class Comment extends Model<Comment> {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private Long blogId;

    private Long parentCommentId;

    private Boolean adminComment;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

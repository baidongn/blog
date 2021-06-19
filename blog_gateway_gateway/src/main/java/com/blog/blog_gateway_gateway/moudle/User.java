package com.blog.blog_gateway_gateway.moudle;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author bd
 * @since 2021-06-06
 */
@Data
public class User  {

private static final long serialVersionUID=1L;

    private Long id;

    private String avatar;

    private LocalDateTime createTime;

    private String email;

    private String nickname;

    private String password;

    private Integer type;

    private LocalDateTime updateTime;

    private String username;


}

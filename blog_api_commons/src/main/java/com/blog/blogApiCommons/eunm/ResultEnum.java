package com.blog.blogApiCommons.eunm;

public enum ResultEnum {

    SUCCESS(200, "成功"),

    ERR_MSG(500, "错误"),

    ERR_TOKEN(501, "token出错"),

    ERR_EXCEPTION(999, "异常抛出信息"),

    LOGIN_EXCEPTION(000, "登录失效，请重新登录");

    private final Integer code;

    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}


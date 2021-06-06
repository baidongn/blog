package com.blog.blogApiCommons.utils;
import com.blog.blogApiCommons.eunm.ResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author： bd
 * @Description:
 *          方法                 信息
 *           ok                 200：表示成功
 *      	errorMsg:			500：表示错误，错误信息在msg字段中
 *      	errorTokenMsg		501：拦截器拦截到用户token出错
 *      	exceptionMsg		502：异常抛出信息
 * @Date: Created in 16:28 2020/12/8
 */
@Data
@ApiModel(value="返回结果", description="返回结果")
@NoArgsConstructor
public class JSONResult<T> implements Serializable {
    static final long serialVersionUID = -7034897190766939L;
    // 响应业务状态
    @ApiModelProperty(value = "响应业务状态")
    private Integer status;

    // 响应消息
    @ApiModelProperty(value = "响应消息")
    private String msg;

    // 响应中的数据
    @ApiModelProperty(value = "响应中的数据")
    private T data;


    public static<T> JSONResult build(Integer status, String msg, T data) {
        return new JSONResult(status, msg, data);
    }


    public static<T> JSONResult success(T data) {
        return new JSONResult(data);
    }

    public static JSONResult success() {
        return new JSONResult(null);
    }

    public static JSONResult errorMsg(String msg) {
        return new JSONResult(ResultEnum.ERR_MSG.getCode(), msg, null);
    }

    public static<T> JSONResult errorTokenMsg(T data) {
        return new JSONResult(ResultEnum.ERR_TOKEN.getCode(), ResultEnum.ERR_TOKEN.getMessage(), data);
    }

    public static JSONResult exceptionMsg(String msg) {
        return new JSONResult(ResultEnum.ERR_EXCEPTION.getCode(), msg, null);
    }

    public static JSONResult error(ResultEnum resultEnum) {
        return new JSONResult(resultEnum.getCode(), resultEnum.getMessage(),  null);
    }


    public JSONResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(T data) {
        this.status = ResultEnum.SUCCESS.getCode();
        this.msg = "OK";
        this.data = data;
    }


}

package com.okman.common.entity;

import com.okman.common.constants.StatusCodeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Iverson
 * @Description 功能说明：
 * @Date 2020/11/9 15:08
 * @Copyright © 2020 深圳桑达商用机器有限公司 All rights reserved
 */
@Data
@ApiModel(description = "结果返回实体")
public class Result<T> {

    @ApiModelProperty("是否成功标志")
    private boolean flag;

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
        this.flag = true;
        this.code = StatusCodeConstant.OK;
        this.message = "操作成功!";
    }
}

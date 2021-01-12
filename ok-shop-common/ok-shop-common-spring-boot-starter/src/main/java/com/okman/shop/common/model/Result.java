package com.okman.shop.common.model;

import com.okman.shop.common.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 17:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1106846796511708508L;

    private T data;
    private Integer code;
    private String msg;

    public static <T> Result<T> succeed() {
        return restResult(null, CodeEnum.SUCCESS.getCode(), null);
    }

    public static <T> Result<T> succeed(T data) {
        return restResult(data, CodeEnum.SUCCESS.getCode(), null);
    }

    public static <T> Result<T> succeed(String msg) {
        return restResult(null, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T data, String msg) {
        return restResult(data, CodeEnum.SUCCESS.getCode(), msg);
    }



    public static <T> Result<T> failed() {
        return restResult(null, CodeEnum.ERROR.getCode(), null);
    }

    public static <T> Result<T> failed(String msg) {
        return restResult(null, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(T data) {
        return restResult(data, CodeEnum.ERROR.getCode(), null);
    }

    public static <T> Result<T> failed(T data, String msg) {
        return restResult(data, CodeEnum.ERROR.getCode(), msg);
    }

    private static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}

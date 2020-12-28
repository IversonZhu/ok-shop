package com.okman.common.exception;

import org.springframework.http.HttpStatus;

/**
 * <p>
 * 系统异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：业务异常处理类
 * @Date 2020/12/28 13:34
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = -2518760608763628086L;

    private int code = HttpStatus.OK.value();

    private String message;

    private String source;

    public SystemException() {
    }

    public SystemException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "SystemException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}

package com.okman.shop.common.exception;

/**
 * <p>
 * 业务异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 16:48
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 720537159300309735L;

    public BusinessException(String message) {
        super(message);
    }
}

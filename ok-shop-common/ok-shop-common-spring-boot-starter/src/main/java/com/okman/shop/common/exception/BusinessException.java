package com.okman.shop.common.exception;

import lombok.NoArgsConstructor;

/**
 * <p>
 * 业务异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 16:48
 */
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 51535497231340871L;

    public BusinessException(String message) {
        super(message);
    }
}

package com.okman.shop.common.exception;

import lombok.NoArgsConstructor;

/**
 * <p>
 * ValidateCodeException
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 15:06
 */
@NoArgsConstructor
public class ValidateCodeException extends RuntimeException {

    private static final long serialVersionUID = 4596994394645762479L;

    public ValidateCodeException(String message) {
        super(message);
    }
}

package com.okman.shop.common.exception;

import lombok.NoArgsConstructor;

/**
 * <p>
 * 幂等性异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：幂等性异常
 * @Date 2020/12/30 16:50
 */
@NoArgsConstructor
public class IdempotencyException extends RuntimeException {
    private static final long serialVersionUID = -2058243160471215038L;

    public IdempotencyException(String message) {
        super(message);
    }
}

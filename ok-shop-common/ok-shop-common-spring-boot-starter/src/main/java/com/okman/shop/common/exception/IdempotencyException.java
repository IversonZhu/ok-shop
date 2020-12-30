package com.okman.shop.common.exception;

/**
 * <p>
 * 幂等性异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：幂等性异常
 * @Date 2020/12/30 16:50
 */
public class IdempotencyException extends RuntimeException {
    private static final long serialVersionUID = 1417457064021388382L;

    public IdempotencyException(String message) {
        super(message);
    }
}

package com.okman.shop.common.exception;

/**
 * <p>
 * 分布式锁异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 16:51
 */
public class LockException extends RuntimeException {
    private static final long serialVersionUID = -9112487590300709306L;

    public LockException(String message) {
        super(message);
    }
}

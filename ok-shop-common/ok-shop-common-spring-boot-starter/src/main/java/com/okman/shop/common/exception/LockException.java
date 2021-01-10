package com.okman.shop.common.exception;

import lombok.NoArgsConstructor;

/**
 * <p>
 * 分布式锁异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 16:51
 */
@NoArgsConstructor
public class LockException extends RuntimeException {
    private static final long serialVersionUID = 2523803653017399774L;

    public LockException(String message) {
        super(message);
    }
}

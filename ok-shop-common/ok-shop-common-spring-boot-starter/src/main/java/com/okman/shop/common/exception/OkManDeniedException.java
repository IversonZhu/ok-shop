package com.okman.shop.common.exception;

import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/12 11:47
 */
@NoArgsConstructor
public class OkManDeniedException extends RuntimeException {

    private static final long serialVersionUID = 7023553757057875998L;

    public OkManDeniedException(String message) {
        super(message);
    }

    public OkManDeniedException(Throwable cause) {
        super(cause);
    }

    public OkManDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OkManDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

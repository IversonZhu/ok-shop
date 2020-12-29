package com.okman.shop.common.exception;

import org.springframework.http.HttpStatus;

/**
 * <p>
 * 未认证异常
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：未认证异常
 * @Date 2020/12/28 13:42
 */
public class UnAuthorizedException extends SystemException {

    private static final long serialVersionUID = -8836999504667393244L;

    public UnAuthorizedException(String reason) {
        super(HttpStatus.UNAUTHORIZED.value(), reason);
    }

    public UnAuthorizedException() {
        super(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
    }
}

package com.okman.shop.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.okman.shop.security.component.OkManAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * <p>
 * InvalidException
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:43
 */
@JsonSerialize(using = OkManAuth2ExceptionSerializer.class)
public class InvalidException extends OkManAuth2Exception {


    public InvalidException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "invalid_exception";
    }

    @Override
    public int getHttpErrorCode() {
        return 426;
    }
}

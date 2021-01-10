package com.okman.shop.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.okman.shop.security.component.OkManAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * <p>
 * OkManAuth2Exception
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:37
 */
@JsonSerialize(using = OkManAuth2ExceptionSerializer.class)
public class OkManAuth2Exception extends OAuth2Exception {

    @Getter
    private String errorCode;

    public OkManAuth2Exception(String msg) {
        super(msg);
    }

    public OkManAuth2Exception(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}

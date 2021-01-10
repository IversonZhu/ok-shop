package com.okman.shop.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.okman.shop.common.constant.CommonConstants;
import com.okman.shop.security.exception.OkManAuth2Exception;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * <p>
 * PigAuth2ExceptionSerializer
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:38
 */
public class OkManAuth2ExceptionSerializer extends StdSerializer<OkManAuth2Exception> {

    public OkManAuth2ExceptionSerializer() {
        super(OkManAuth2Exception.class);
    }

    @Override
    @SneakyThrows
    public void serialize(OkManAuth2Exception e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("code", CommonConstants.FAIL);
        jsonGenerator.writeStringField("msg", e.getMessage());
        jsonGenerator.writeStringField("data", e.getErrorCode());
        jsonGenerator.writeEndObject();
    }
}

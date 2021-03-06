package com.okman.shop.gateway.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okman.shop.common.model.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 网关异常通用处理器，只作用在webflux 环境下 , 优先级低于 {@link ResponseStatusExceptionHandler} 执行
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 14:57
 */

@Slf4j
@Order(-1)
@Component
@RequiredArgsConstructor
public class GatewayGlobalExceptionHandler implements ErrorWebExceptionHandler {

    private final ObjectMapper objectMapper;

    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpResponse response = serverWebExchange.getResponse();

        if (response.isCommitted()) {
            return Mono.error(throwable);
        }

        // header set
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        if (throwable instanceof ResponseStatusException) {
            response.setStatusCode(((ResponseStatusException) throwable).getStatus());
        }

        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = response.bufferFactory();
            try {
                return bufferFactory.wrap(objectMapper.writeValueAsBytes(Result.failed(throwable.getMessage())));
            }
            catch (JsonProcessingException e) {
                log.error("Error writing response", throwable);
                return bufferFactory.wrap(new byte[0]);
            }
        }));
    }
}

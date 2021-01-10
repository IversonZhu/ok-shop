package com.okman.shop.log.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * 日志类型
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：日志类型
 * @Date 2021/1/9 18:52
 */
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum LogTypeEnum {
    /**
     * 正常日志类型
     */
    NORMAL("0", "正常日志"),

    /**
     * 错误日志类型
     */
    ERROR("9", "错误日志");

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;
}

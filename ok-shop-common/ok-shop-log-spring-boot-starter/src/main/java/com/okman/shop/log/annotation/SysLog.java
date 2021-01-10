package com.okman.shop.log.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 操作日志注解
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：操作日志注解
 * @Date 2021/1/9 18:48
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**
     * 描述
     * @return {String}
     */
    String value();
}

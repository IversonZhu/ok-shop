package com.okman.shop.common.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 忽略Token验证注解
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：忽略Token验证
 * @Date 2020/12/30 16:45
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {
    String value() default "";
}

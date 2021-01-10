package com.okman.shop.security.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 服务调用不鉴权注解(支持方法、类级别)
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:09
 */

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotAuth {

    /**
     * 是否AOP统一处理
     * @return false, true
     */
    boolean value() default true;

    /**
     * 需要特殊判空的字段(预留)
     * @return {}
     */
    String[] field() default {};
}

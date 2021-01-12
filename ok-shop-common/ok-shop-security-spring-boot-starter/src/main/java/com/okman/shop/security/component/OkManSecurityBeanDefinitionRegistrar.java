package com.okman.shop.security.component;

import com.okman.shop.security.adapter.OkManResourceServerConfigurerAdapter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.okman.shop.common.constant.SysConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/12 13:56
 */
@Slf4j
public class OkManSecurityBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 根据注解值动态注入资源服务器的相关属性
     * 
     * @param metadata 注解信息
     * @param registry 注册器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        if (registry.isBeanNameInUse(SysConstants.RESOURCE_SERVER_CONFIGURER)) {
            log.warn("本地存在资源服务器配置，覆盖默认配置:" + SysConstants.RESOURCE_SERVER_CONFIGURER);
            return;
        }

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(OkManResourceServerConfigurerAdapter.class);
        registry.registerBeanDefinition(SysConstants.RESOURCE_SERVER_CONFIGURER, beanDefinition);

    }
}

package com.okman.shop.security.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * OkManUserDetailsServiceImpl
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:55
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class OkManUserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户密码登录
     * @param username 用户名
     * @return UserDetails.class
     */
    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String username){
        return null;
    }
}

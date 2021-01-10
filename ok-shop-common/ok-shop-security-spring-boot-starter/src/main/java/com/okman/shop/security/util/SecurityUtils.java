package com.okman.shop.security.util;

import cn.hutool.core.util.StrUtil;
import com.okman.shop.common.constant.SysConstants;
import com.okman.shop.security.dto.OkManUserDto;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 安全工具类
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：安全工具类
 * @Date 2021/1/10 13:35
 */
@UtilityClass
public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public OkManUserDto getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof OkManUserDto) {
            return (OkManUserDto) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public OkManUserDto getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户角色信息
     * @return 角色集合
     */
    public List<Integer> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<Integer> roleIds = new ArrayList<>();
        authorities.stream().filter(granted -> StrUtil.startWith(granted.getAuthority(), SysConstants.ROLE))
                .forEach(granted -> {
                    String id = StrUtil.removePrefix(granted.getAuthority(), SysConstants.ROLE);
                    roleIds.add(Integer.parseInt(id));
                });
        return roleIds;
    }
}

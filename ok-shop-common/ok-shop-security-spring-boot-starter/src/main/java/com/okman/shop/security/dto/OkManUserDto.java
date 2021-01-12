package com.okman.shop.security.dto;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

/**
 * <p>
 * 扩展用户信息
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：扩展用户信息
 * @Date 2021/1/10 13:13
 */
public class OkManUserDto extends User {

    private static final long serialVersionUID = 1623082255119872853L;
    /**
     * 用户ID
     */
    @Getter
    private Integer id;

    /**
     * 部门ID
     */
    @Getter
    private Integer deptId;

    public OkManUserDto(Integer id, Integer deptId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.deptId = deptId;
    }
}

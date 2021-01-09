package com.okman.shop.upms.web.controller;

import com.okman.shop.common.model.Result;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * RoleController
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/9 14:27
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@Api(value = "role", tags = "角色管理模块")
public class RoleController {



    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return null;
    }
}

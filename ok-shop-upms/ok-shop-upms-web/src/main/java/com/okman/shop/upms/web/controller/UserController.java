package com.okman.shop.upms.web.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.okman.shop.common.model.Result;
import com.okman.shop.upms.service.entity.SysUser;
import com.okman.shop.upms.service.service.SysUserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/8 16:29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(value = "user", tags = "用户管理模块")
public class UserController {

    private final SysUserService userService;

    /**
     * 获取当前用户全部信息
     *
     * @return 用户信息
     */
    @GetMapping(value = {"/info"})
    public Result info() {
        return null;
    }

    /**
     * 获取指定用户全部信息
     *
     * @param username
     * @return
     */
    @GetMapping("/info/{username}")
    public Result info(@PathVariable String username) {
        SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
        if (user == null) {
            return Result.failed("用户信息为空");
        }
        return Result.succeed(user);
    }

    /**
     * 通过ID查询用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result user(@PathVariable Integer id) {
        return Result.succeed(userService.getById(id));
    }



}

package com.okman.shop.upms.web.controller;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.okman.shop.common.model.Result;
import com.okman.shop.log.annotation.SysLog;
import com.okman.shop.upms.service.entity.SysRole;
import com.okman.shop.upms.service.service.SysRoleService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

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

    private final SysRoleService roleService;

    /**
     * 通过ID查询角色信息
     * 
     * @param id ID
     * @return 角色信息
     */

    @GetMapping("/{id}")
    public Result<SysRole> getById(@PathVariable Integer id) {
        return Result.succeed(roleService.getById(id));
    }

    /**
     * 添加角色
     * 
     * @param sysRole 角色信息
     * @return success、false
     */
    @SysLog("添加角色")
    @PostMapping("/save")
    @PreAuthorize("@pms.hasPermission('sys_role_add')")
    public Result save(@RequestBody @Valid SysRole sysRole) {
        return Result.succeed(roleService.save(sysRole));
    }

    /**
     * 修改角色
     * 
     * @param sysRole 角色信息
     * @return success/false
     */
    @SysLog("更新角色")
    @PutMapping("/update")
    @PreAuthorize("@pms.hasPermission('sys_role_update')")
    public Result update(@RequestBody @Valid SysRole sysRole) {
        return Result.succeed(roleService.updateById(sysRole));
    }

    /**
     * 删除角色
     *
     * @param id ID
     * @return success/false
     */
    @SysLog("删除角色")
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_role_del')")
    public Result removeById(@PathVariable Integer id) {
        return Result.succeed(roleService.removeById(id));
    }


}

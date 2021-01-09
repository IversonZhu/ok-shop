package com.okman.shop.upms.service.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 17:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends Model<SysRoleMenu> {

    private static final long serialVersionUID = 4568054117794838055L;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单id")
    private Integer menuId;

}

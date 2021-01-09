package com.okman.shop.upms.service.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 17:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1971079415193592777L;

    @TableId(value = "role_id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色编号")
    private Integer roleId;

    @NotBlank(message = "角色名称 不能为空")
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @NotBlank(message = "角色标识 不能为空")
    @ApiModelProperty(value = "角色标识")
    private String roleCode;

    @NotBlank(message = "角色描述 不能为空")
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableLogic
    private String delFlag;

}

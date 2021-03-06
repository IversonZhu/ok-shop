package com.okman.shop.upms.service.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门关系表
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 17:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDeptRelation extends Model<SysDeptRelation> {

    private static final long serialVersionUID = 4593184155949270850L;

    /**
     * 祖先节点
     */
    @ApiModelProperty(value = "祖先节点")
    private Integer ancestor;

    /**
     * 后代节点
     */
    @ApiModelProperty(value = "后代节点")
    private Integer descendant;

}

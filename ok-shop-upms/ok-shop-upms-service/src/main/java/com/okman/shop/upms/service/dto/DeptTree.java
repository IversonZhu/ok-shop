package com.okman.shop.upms.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门树
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 17:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends TreeNode {

    private String name;

}

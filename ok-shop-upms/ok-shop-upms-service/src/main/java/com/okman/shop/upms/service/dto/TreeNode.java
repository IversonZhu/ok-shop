package com.okman.shop.upms.service.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * <p>
 * 树节点
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 17:21
 */
@Data
public class TreeNode {

    protected int id;

    protected int parentId;

    protected List<TreeNode> children = new ArrayList<TreeNode>();

    protected Boolean hasChildren;

    public void add(TreeNode node) {
        children.add(node);
    }

}

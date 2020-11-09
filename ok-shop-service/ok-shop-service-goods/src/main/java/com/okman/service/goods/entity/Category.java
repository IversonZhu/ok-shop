package com.okman.service.goods.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Iverson
 * @Description 功能说明：Category实体
 * @Date 2020/11/9 15:49
 * @Copyright © 2020 深圳桑达商用机器有限公司 All rights reserved
 */
@ApiModel(description = "Category", value = "Category")
@Table(name = "tb_category")
@Data
public class Category implements Serializable {

    @ApiModelProperty(value = "分类ID", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "分类名称", required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "商品数量", required = false)
    @Column(name = "goods_num")
    private Integer goodsNum;

    @ApiModelProperty(value = "是否显示", required = false)
    @Column(name = "is_show")
    private String isShow;

    @ApiModelProperty(value = "是否导航", required = false)
    @Column(name = "is_menu")
    private String isMenu;

    @ApiModelProperty(value = "排序", required = false)
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(value = "上级ID", required = false)
    @Column(name = "parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "模板ID", required = false)
    @Column(name = "template_id")
    private Integer templateId;
}

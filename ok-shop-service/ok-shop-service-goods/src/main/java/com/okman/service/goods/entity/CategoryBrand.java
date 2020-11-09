package com.okman.service.goods.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author Iverson
 * @Description 功能说明：CategoryBrand实体
 * @Date 2020/11/9 15:49
 * @Copyright © 2020 深圳桑达商用机器有限公司 All rights reserved
 */
@ApiModel(description = "CategoryBrand", value = "CategoryBrand")
@Table(name = "tb_category_brand")
@Data
public class CategoryBrand implements Serializable {

    @ApiModelProperty(value = "分类ID", required = false)
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @ApiModelProperty(value = "品牌ID", required = false)
    @Id
    @Column(name = "brand_id")
    private Integer brandId;//品牌ID
}

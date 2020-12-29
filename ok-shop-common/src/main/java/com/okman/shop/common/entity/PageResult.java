package com.okman.shop.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Iverson
 * @Description 功能说明：分页返回结果实体
 * @Date 2020/11/9 15:15
 * @Copyright © 2020 深圳桑达商用机器有限公司 All rights reserved
 */
@Data
@ApiModel(description = "分页返回结果实体")
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    @ApiModelProperty("总记录数")
    private Long total;

    @ApiModelProperty("记录")
    private List<T> rows;
}

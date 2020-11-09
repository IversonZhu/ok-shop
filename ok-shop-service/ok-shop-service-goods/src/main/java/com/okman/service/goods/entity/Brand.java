package com.okman.service.goods.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author Iverson
 * @Description 功能说明：Brand实体
 * @Date 2020/11/9 15:49
 * @Copyright © 2020 深圳桑达商用机器有限公司 All rights reserved
 */
@Data
@Table(name = "tb_brand")
public class Brand implements Serializable {
    //品牌id
    @Id
    private Integer id;
    //品牌名称
    private String name;
    //品牌图片地址
    private String image;
    //品牌的首字母
    private String letter;
    //排序
    private Integer seq;
}

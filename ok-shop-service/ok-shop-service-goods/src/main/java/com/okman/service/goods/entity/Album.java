package com.okman.service.goods.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Iverson
 * @Description 功能说明：Album实体
 * @Date 2020/11/9 15:49
 * @Copyright © 2020 深圳桑达商用机器有限公司 All rights reserved
 */
@Data
@Table(name = "tb_album")
public class Album implements Serializable {

	//编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

	//相册名称
    @Column(name = "title")
    private String title;

	//相册封面
    @Column(name = "image")
    private String image;

	//图片列表
    @Column(name = "image_items")
    private String imageItems;

}

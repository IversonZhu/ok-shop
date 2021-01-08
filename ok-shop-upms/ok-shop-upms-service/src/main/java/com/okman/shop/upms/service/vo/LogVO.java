package com.okman.shop.upms.service.vo;

import java.io.Serializable;

import com.okman.shop.upms.service.entity.SysLog;

import lombok.Data;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@Data
public class LogVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private SysLog sysLog;

    private String username;

}

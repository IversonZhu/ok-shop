package com.okman.shop.db.config;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * <p>
 * 自定义填充公共 name 字段
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/31 9:29
 */
public class DateMetaObjectHandler implements MetaObjectHandler {

    private final static String UPDATE_TIME = "updateTime";
    private final static String CREATE_TIME = "createTime";

    /**
     * 插入填充，字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        /*Object createTime = getFieldValByName(CREATE_TIME, metaObject);
        Object updateTime = getFieldValByName(UPDATE_TIME, metaObject);
        if (createTime == null || updateTime == null) {
            Date date = new Date();
            if (createTime == null) {
                setFieldValByName(CREATE_TIME, date, metaObject);
            }
            if (updateTime == null) {
                setFieldValByName(UPDATE_TIME, date, metaObject);
            }
        }*/
    }

    /**
     * 更新填充
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // mybatis-plus版本2.0.9+
        // setFieldValByName(UPDATE_TIME, new Date(), metaObject);
    }
}

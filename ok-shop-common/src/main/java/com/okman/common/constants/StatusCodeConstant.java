package com.okman.common.constants;

/**
 * @Author Iverson
 * @Description 功能说明：返回码
 * @Date 2020/11/9 15:13
 * @Copyright © 2020 深圳桑达商用机器有限公司 All rights reserved
 */
public class StatusCodeConstant {
    public static final int OK = 20000;//成功
    public static final int ERROR = 20001;//失败
    public static final int LOGINERROR = 20002;//用户名或密码错误
    public static final int ACCESSERROR = 20003;//权限不足
    public static final int REMOTEERROR = 20004;//远程调用失败
    public static final int REPERROR = 20005;//重复操作
    public static final int NOTFOUNDERROR = 20006;//没有对应的抢购数据
}

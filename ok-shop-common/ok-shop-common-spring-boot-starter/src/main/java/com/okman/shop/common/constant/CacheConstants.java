package com.okman.shop.common.constant;

/**
 * <p>
 * 缓存的key 常量
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:56
 */
public interface CacheConstants {

    /**
     * oauth 缓存前缀
     */
    String PROJECT_OAUTH_ACCESS = "OK_SHOP_OAUTH:ACCESS:";

    /**
     * oauth 缓存令牌前缀
     */
    String PROJECT_OAUTH_TOKEN = "OK_SHOP_OAUTH:TOKEN:";

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY:";

    /**
     * 菜单信息缓存
     */
    String MENU_DETAILS = "MENU_DETAILS";

    /**
     * 用户信息缓存
     */
    String USER_DETAILS = "USER_DETAILS";

    /**
     * 字典信息缓存
     */
    String DICT_DETAILS = "DICT_DETAILS";

    /**
     * oauth 客户端信息
     */
    String CLIENT_DETAILS_KEY = "OK_SHOP_OAUTH:CLIENT:DETAILS";

    /**
     * 参数缓存
     */
    String PARAMS_DETAILS = "PARAMS_DETAILS";
}

package com.okman.shop.sentinel.config;

//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
//import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.okman.shop.common.model.Result;
//
//import cn.hutool.json.JSONUtil;

/**
 * <p>
 * Sentinel配置类
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/31 10:51
 */
public class SentinelAutoConfig {
//    public SentinelAutoConfig() {
//        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
//    }
//
//    /**
//     * 限流、熔断统一处理类
//     */
//    public class CustomUrlBlockHandler implements UrlBlockHandler {
//        @Override
//        public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//            BlockException e) throws IOException {
//            Result result = Result.failed("flow-limiting");
//            httpServletResponse.getWriter().print(JSONUtil.toJsonStr(result));
//        }
//    }
}

package com.okman.shop.auth.endpoint;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.okman.shop.common.constant.CacheConstants;
import com.okman.shop.common.constant.CommonConstants;
import com.okman.shop.common.model.Result;
import com.okman.shop.security.annotation.NotAuth;
import com.okman.shop.security.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.ConvertingCursor;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * TokenEndpointController
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:02
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenEndpointController {

    private final ClientDetailsService clientDetailsService;

    private final TokenStore tokenStore;

    private final RedisTemplate redisTemplate;

    private final CacheManager cacheManager;

    /**
     * 认证页面
     * @param modelAndView
     * @param error 表单登录失败处理回调的错误信息
     * @return ModelAndView
     */
    @GetMapping("/login")
    public ModelAndView require(ModelAndView modelAndView, @RequestParam(required = false) String error) {
        modelAndView.setViewName("ftl/login");
        modelAndView.addObject("error", error);
        return modelAndView;
    }

    /**
     * 确认授权页面
     * @param request
     * @param session
     * @param modelAndView
     * @return
     */
    @GetMapping("/confirm_access")
    public ModelAndView confirm(HttpServletRequest request, HttpSession session, ModelAndView modelAndView) {
        Map<String, Object> scopeList = (Map<String, Object>) request.getAttribute("scopes");
        modelAndView.addObject("scopeList", scopeList.keySet());

        Object auth = session.getAttribute("authorizationRequest");
        if (auth != null) {
            AuthorizationRequest authorizationRequest = (AuthorizationRequest) auth;
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(authorizationRequest.getClientId());
            modelAndView.addObject("app", clientDetails.getAdditionalInformation());
            modelAndView.addObject("user", SecurityUtils.getUser());
        }

        modelAndView.setViewName("ftl/confirm");
        return modelAndView;
    }

    /**
     * 退出并删除token
     * @param authHeader Authorization
     */
    @DeleteMapping("/logout")
    public Result<Boolean> logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        if (StrUtil.isBlank(authHeader)) {
            return Result.succeed();
        }

        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, StrUtil.EMPTY).trim();
        return removeToken(tokenValue);
    }

    /**
     * 令牌管理调用
     * @param token token
     */
    @NotAuth
    @DeleteMapping("/{token}")
    public Result<Boolean> removeToken(@PathVariable("token") String token) {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        if (accessToken == null || StrUtil.isBlank(accessToken.getValue())) {
            return Result.succeed();
        }

        OAuth2Authentication auth2Authentication = tokenStore.readAuthentication(accessToken);
        // 清空用户信息
        cacheManager.getCache(CacheConstants.USER_DETAILS).evict(auth2Authentication.getName());

        // 清空access token
        tokenStore.removeAccessToken(accessToken);

        // 清空 refresh token
        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
        tokenStore.removeRefreshToken(refreshToken);
        return Result.succeed();
    }

    /**
     * 查询token
     * @param params 分页参数
     * @return
     */
    @NotAuth
    @PostMapping("/page")
    public Result<Page> tokenList(@RequestBody Map<String, Object> params) {
        // 根据分页参数获取对应数据
        String key = String.format("%sAUTH_TO_ACCESS:*", CacheConstants.PROJECT_OAUTH_ACCESS);
        List<String> pages = findKeysForPage(key, MapUtil.getInt(params, CommonConstants.CURRENT),
                MapUtil.getInt(params, CommonConstants.SIZE));

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Page result = new Page(MapUtil.getInt(params, CommonConstants.CURRENT),
                MapUtil.getInt(params, CommonConstants.SIZE));
        result.setRecords(redisTemplate.opsForValue().multiGet(pages));
        result.setTotal(redisTemplate.keys(key).size());
        return Result.succeed(result);
    }

    private List<String> findKeysForPage(String patternKey, int pageNum, int pageSize) {
        ScanOptions options = ScanOptions.scanOptions().count(1000L).match(patternKey).build();
        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        Cursor cursor = (Cursor) redisTemplate.executeWithStickyConnection(
                redisConnection -> new ConvertingCursor<>(redisConnection.scan(options), redisSerializer::deserialize));
        List<String> result = new ArrayList<>();
        int tmpIndex = 0;
        int startIndex = (pageNum - 1) * pageSize;
        int end = pageNum * pageSize;

        assert cursor != null;
        while (cursor.hasNext()) {
            if (tmpIndex >= startIndex && tmpIndex < end) {
                result.add(cursor.next().toString());
                tmpIndex++;
                continue;
            }
            if (tmpIndex >= end) {
                break;
            }
            tmpIndex++;
            cursor.next();
        }

        try {
            cursor.close();
        }
        catch (IOException e) {
            log.error("关闭cursor 失败");
        }
        return result;
    }
}

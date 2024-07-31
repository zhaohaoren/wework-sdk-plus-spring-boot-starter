package com.wework.sdk.starter.sdk.core;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.base.TokenRequest;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import com.wework.sdk.starter.sdk.wework.exception.WxCorpInvalidException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaohaoren
 */
@Data
@Slf4j
public class WeWorkClient {

    private String corpId;

    private String agentId;

    private String secret;

    private volatile String token;


    public <T> T request(WxApiBaseRequest<T> request) {
        if (StrUtil.isBlank(token)) {
            refreshToken(null);
        }
        try {
            String curToken = this.token;
            try {
                return request.request(curToken);
            } catch (TokenExpiredException tokenExpiredException) {
                log.info("token expired: {}", this.corpId);
                refreshToken(curToken);
                if (StrUtil.isBlank(this.token)) {
                    return null;
                }
                return request.request(token);
            }
        } catch (TokenExpiredException e) {
            log.error("微信API请求请求失败！request=> {}", JSONUtil.toJsonStr(request), e);
        }
        return null;
    }


    private synchronized void refreshToken(String oldToken) {
        //刷新api的token
        if (StrUtil.isNotBlank(oldToken) && StrUtil.isNotBlank(this.token) && !oldToken.equals(this.token)) {
            log.info("token已被其他线程更新");
            return;
        }
        // 刷新token
        try {
            log.info(">>>> 线程【{}】更新主体 【{}】token开始", Thread.currentThread().getName(), corpId);
            this.token = TokenRequest.builder().corpId(corpId).secret(secret).build().request(null);
            log.info("<<<< 线程【{}】更新主体 【{}】token结束", Thread.currentThread().getName(), corpId);
        } catch (WxCorpInvalidException e) {
            log.info("{} 主体失效，设置token标志位", this.corpId);
            this.token = null;
        }
    }


}

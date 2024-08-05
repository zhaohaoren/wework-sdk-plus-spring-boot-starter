package com.wework.sdk.starter.sdk.core;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.base.TokenRequest;
import com.wework.sdk.starter.sdk.wework.api.corpgroup.DownStreamTokenRequest;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import com.wework.sdk.starter.sdk.wework.exception.WxCorpInvalidException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

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

    /**
     * 上游的主体
     */
    private WeWorkClient upperStreamClient;


    public <T> T request(WxApiBaseRequest<T> request) {
        if (StrUtil.isBlank(token)) {
            refreshToken(null);
        }
        try {
            if (Objects.isNull(upperStreamClient)) {
                request.corpRoute = this.corpId;
            } else {
                request.corpRoute = this.upperStreamClient.corpId;
            }
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
            log.error("request wework fail！request=> {}", JSONUtil.toJsonStr(request), e);
        }
        return null;
    }


    private synchronized void refreshToken(String oldToken) {
        //刷新api的token
        if (StrUtil.isNotBlank(oldToken) && StrUtil.isNotBlank(this.token) && !oldToken.equals(this.token)) {
            log.info("token was updated");
            return;
        }
        // 刷新token
        try {
            log.info(">>>> thread:{} update corp {} token start", Thread.currentThread().getName(), corpId);
            if (Objects.isNull(upperStreamClient)) {
                // 主体本体token
                this.token = TokenRequest.builder().corpId(corpId).secret(secret).build().request();
            } else {
                try {
                    // todo: token设置
                    // 更新下游的token
                    this.token = DownStreamTokenRequest.builder().build().request(upperStreamClient.getToken());
                } catch (TokenExpiredException e) {
                    try {
                        this.token = DownStreamTokenRequest.builder().build().request(TokenRequest.builder().corpId(upperStreamClient.getCorpId())
                                .secret(upperStreamClient.getSecret()).build().request());
                    } catch (TokenExpiredException ex) {
                        log.error("update {} token fail", corpId, ex);
                    }
                }
            }
            log.info(">>>> thread {} update corp {}token end", Thread.currentThread().getName(), corpId);
        } catch (WxCorpInvalidException e) {
            log.info("{} corp invalid", this.corpId);
            this.token = null;
        }
    }


}

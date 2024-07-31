package com.wework.sdk.starter.sdk.wework.api.base;

import cn.hutool.core.util.StrUtil;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.base.response.TokenResponse;
import com.wework.sdk.starter.sdk.wework.consts.WxErrCodeEnum;
import com.wework.sdk.starter.sdk.wework.exception.WxCorpInvalidException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author zhaohaoren
 */
@Data
@Slf4j
@Builder
public class TokenRequest {

    private static final String URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";

    private String corpId;
    private String secret;

    public String request(String token) throws WxCorpInvalidException {
        TokenResponse tokenResponse = WxSdkHttpUtil.get(String.format(URL, corpId, secret), TokenResponse.class);
        if (Objects.isNull(tokenResponse)) {
            log.error("获取token接口返回空");
            return StrUtil.EMPTY;
        }

        if (StrUtil.isNotBlank(tokenResponse.getAccessToken())) {
            return tokenResponse.getAccessToken();
        }
        if (WxErrCodeEnum.TOKEN_FREQUENT.getErrCode().equals(tokenResponse.getErrCode())) {
            log.error("token请求太频繁");
        }
        if (WxErrCodeEnum.CORP_INVALID.getErrCode().equals(tokenResponse.getErrCode())) {
            log.error("{} 主体失效", corpId);
            throw new WxCorpInvalidException();
        }
        return StrUtil.EMPTY;
    }
}

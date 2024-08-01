package com.wework.sdk.starter.sdk.wework.api.corpgroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.base.response.TokenResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取下级/下游企业的access_token
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/95816">...</a>
 */
@Data
@Slf4j
@Builder
public class DownStreamTokenRequest implements WxApiBaseRequest<String> {

    private static final String URL = "https://qyapi.weixin.qq.com/cgi-bin/corpgroup/corp/gettoken?access_token=";

    @JsonProperty("corpid")
    private String corpId;
    @JsonProperty("business_type")
    private Integer businessType;
    @JsonProperty("agentid")
    private Integer agentId;

    @Override
    public String request(String token) throws TokenExpiredException {
        TokenResponse tokenResponse = WxSdkHttpUtil.post(URL + token, this, new TypeReference<TokenResponse>() {
        }, false);
        return tokenResponse.getAccessToken();
    }
}

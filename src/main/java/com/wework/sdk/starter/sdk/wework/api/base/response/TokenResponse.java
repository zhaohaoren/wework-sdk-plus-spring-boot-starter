package com.wework.sdk.starter.sdk.wework.api.base.response;

import com.wework.sdk.starter.sdk.wework.api.WxApiBaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaohaoren
 */
@Getter
@Setter
public class TokenResponse extends WxApiBaseResponse {
    private String accessToken;
    private Integer expiresIn;
}
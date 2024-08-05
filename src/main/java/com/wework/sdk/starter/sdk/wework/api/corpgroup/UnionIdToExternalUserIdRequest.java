package com.wework.sdk.starter.sdk.wework.api.corpgroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.corpgroup.response.UnionIdToExternalUserIdResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 上下游关联客户信息-已添加客户
 * - 通过unionid和openid查询external_userid
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/95818">...</a>
 */
@Data
@Slf4j
@Builder
public class UnionIdToExternalUserIdRequest extends WxApiBaseRequest<UnionIdToExternalUserIdResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/corpgroup/unionid_to_external_userid?access_token=";

    @JsonProperty("unionid")
    private String unionId;
    @JsonProperty("openid")
    private String openId;
    @JsonProperty("corpid")
    private String corpId;
    @JsonProperty("mass_call_ticket")
    private String massCallTicket;

    @Override
    public UnionIdToExternalUserIdResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.post(URL + token, this.corpRoute, this, new TypeReference<UnionIdToExternalUserIdResponse>() {
        }, false);
    }
}

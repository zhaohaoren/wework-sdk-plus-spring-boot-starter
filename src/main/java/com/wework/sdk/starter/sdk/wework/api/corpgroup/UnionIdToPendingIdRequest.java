package com.wework.sdk.starter.sdk.wework.api.corpgroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.corpgroup.response.UnionIdToPendingIdResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 上下游关联客户信息-未添加客户
 * external_userid查询pending_id
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/97357">...</a>
 */
@Data
@Slf4j
@Builder
public class UnionIdToPendingIdRequest extends WxApiBaseRequest<UnionIdToPendingIdResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/corpgroup/unionid_to_pending_id?access_token=";

    @JsonProperty("unionid")
    private String unionId;
    @JsonProperty("openid")
    private String openId;

    @Override
    public UnionIdToPendingIdResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.post(URL + token, this.corpRoute, this, new TypeReference<UnionIdToPendingIdResponse>() {
        }, false);
    }
}

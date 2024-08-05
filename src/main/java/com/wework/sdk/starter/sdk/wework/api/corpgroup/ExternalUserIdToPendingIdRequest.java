package com.wework.sdk.starter.sdk.wework.api.corpgroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.corpgroup.response.ExternalUserIdToPendingIdResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * external_userid查询pending_id
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/97357#external-userid%E6%9F%A5%E8%AF%A2pending-id">...</a>
 */
@Data
@Slf4j
@Builder
public class ExternalUserIdToPendingIdRequest extends WxApiBaseRequest<ExternalUserIdToPendingIdResponse> {

    private static final String URL = "https://qyapi.weixin.qq.com/cgi-bin/corpgroup/batch/external_userid_to_pending_id?access_token=";

    @JsonProperty("chat_id")
    private String chatId;
    @JsonProperty("external_userid")
    private List<String> externalUserId;

    @Override
    public ExternalUserIdToPendingIdResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.post(URL + token, this.corpRoute, this, new TypeReference<ExternalUserIdToPendingIdResponse>() {
        }, false);
    }
}

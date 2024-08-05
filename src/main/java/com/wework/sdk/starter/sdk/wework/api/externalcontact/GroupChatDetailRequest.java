package com.wework.sdk.starter.sdk.wework.api.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.externalcontact.response.GroupChatDetailResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取客户群详情
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/92122">...</a>
 */
@Data
@Slf4j
@Builder
public class GroupChatDetailRequest extends WxApiBaseRequest<GroupChatDetailResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/get?access_token=";

    @JsonProperty("chat_id")
    private String chatId;
    @JsonProperty("need_name")
    private Integer needName;

    @Override
    public GroupChatDetailResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.post(URL + token, this.corpRoute, this, new TypeReference<GroupChatDetailResponse>() {
        }, false);
    }
}

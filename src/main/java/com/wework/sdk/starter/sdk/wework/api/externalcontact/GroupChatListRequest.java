package com.wework.sdk.starter.sdk.wework.api.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.externalcontact.response.GroupChatListResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 获取客户群列表
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/92120">...</a>
 */
@Data
@Slf4j
@Builder
public class GroupChatListRequest extends WxApiBaseRequest<GroupChatListResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/groupchat/list?access_token=";

    @JsonProperty("status_filter")
    private Integer statusFilter;
    @JsonProperty("owner_filter")
    private UserIdList ownerFilter;
    private String cursor;
    private Integer limit;

    @Override
    public GroupChatListResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.post(URL + token, this.corpRoute, this, new TypeReference<GroupChatListResponse>() {
        }, false);
    }

    @Data
    public static class UserIdList {
        @JsonProperty("userid_list")
        private List<String> userIdList;
    }
}

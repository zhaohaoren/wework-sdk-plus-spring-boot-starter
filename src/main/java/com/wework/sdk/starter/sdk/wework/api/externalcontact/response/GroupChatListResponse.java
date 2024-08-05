package com.wework.sdk.starter.sdk.wework.api.externalcontact.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhaohaoren
 */
@Getter
@Setter
public class GroupChatListResponse extends WxApiBaseResponse {
    @JsonProperty("group_chat_list")
    private List<GroupItem> groupChatList;

    @JsonProperty("next_cursor")
    private String nextCursor;

    @Data
    public static class GroupItem {
        @JsonProperty("chat_id")
        private String chatId;
        private Integer status;
    }

}

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
public class GroupChatDetailResponse extends WxApiBaseResponse {

    @JsonProperty("group_chat")
    private GroupChatDetail groupChat;

    @Data
    public static class GroupChatDetail {
        @JsonProperty("chat_id")
        private String chatId;
        private String name;
        private String owner;
        @JsonProperty("create_time")
        private Long createTime;
        private String notice;
        @JsonProperty("member_list")
        private List<Member> memberList;
        @JsonProperty("admin_list")
        private List<Admin> adminList;
        @JsonProperty("member_version")
        private String memberVersion;
    }

    @Data
    public static class Member {
        @JsonProperty("userid")
        private String userId;
        private Integer type;
        @JsonProperty("unionid")
        private String unionId;
        @JsonProperty("join_time")
        private Long joinTime;
        @JsonProperty("join_scene")
        private Integer joinScene;
        private Invitor invitor;
        @JsonProperty("group_nickname")
        private String groupNickname;
        private String name;
    }

    @Data
    public static class Invitor {
        @JsonProperty("userid")
        private String userId;
    }

    @Data
    public static class Admin {
        @JsonProperty("userid")
        private String userId;
    }
}

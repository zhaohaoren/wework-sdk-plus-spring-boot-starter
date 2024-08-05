package com.wework.sdk.starter.sdk.wework.api.externalcontact.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author zhaohaoren
 */
@Getter
@Setter
public class ContactDetailResponse extends WxApiBaseResponse {

    @JsonProperty("external_contact")
    private ExternalContact externalContact;

    @JsonProperty("follow_user")
    private List<FollowUser> followUser;

    @JsonProperty("next_cursor")
    private String nextCursor;

    @Data
    public static class ExternalContact {
        @JsonProperty("external_userid")
        private String externalUserId;
        private String name;
        private String position;
        private String avatar;
        @JsonProperty("corp_name")
        private String corpName;
        @JsonProperty("corp_full_name")
        private String corpFullName;
        private Integer type;
        private Integer gender;
        @JsonProperty("unionid")
        private String unionId;
        @JsonProperty("external_profile")
        private Object externalProfile;
    }

    @Data
    public static class FollowUser {
        @JsonProperty("userid")
        private String userId;
        private String remark;
        private String description;
        @JsonProperty("createtime")
        private Long createTime;
        @JsonProperty("tag_id")
        private List<Tag> tags;
        @JsonProperty("remark_corp_name")
        private String remarkCorpName;
        @JsonProperty("remark_mobiles")
        private List<String> remarkMobiles;
        private String state;
        @JsonProperty("oper_userid")
        private String opUserId;
        @JsonProperty("add_way")
        private Integer addWay;
        @JsonProperty("wechat_channels")
        private Map<String, String> wechatChannels;
    }

    @Data
    public static class Tag {
        @JsonProperty("group_name")
        private String groupName;
        @JsonProperty("tag_name")
        private String tagName;
        @JsonProperty("tag_id")
        private String tagId;
        private Integer type;
    }
}

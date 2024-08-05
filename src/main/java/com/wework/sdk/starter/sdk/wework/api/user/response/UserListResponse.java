package com.wework.sdk.starter.sdk.wework.api.user.response;

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
public class UserListResponse extends WxApiBaseResponse {

    @JsonProperty("userlist")
    private List<User> userList;

    @Data
    public static class User {
        @JsonProperty("userid")
        private String userId;
        private String name;
        private List<Integer> department;
        private List<Integer> order;
        private String position;
        private String mobile;
        private String gender;
        private String email;
        @JsonProperty("biz_mail")
        private String bizMail;
        @JsonProperty("is_leader_in_dept")
        private List<Integer> isLeaderInDept;
        @JsonProperty("direct_leader")
        private List<String> directLeader;
        private String avatar;
        @JsonProperty("thumb_avatar")
        private String thumbAvatar;
        private String telephone;
        private String alias;
        private Integer status;
        private String address;
        @JsonProperty("english_name")
        private String englishName;
        @JsonProperty("open_userid")
        private String openUserId;
        @JsonProperty("main_department")
        private int mainDepartment;
        @JsonProperty("extattr")
        private ExtAttr extAttr;
        @JsonProperty("qr_code")
        private String qrCode;
        @JsonProperty("external_position")
        private String externalPosition;
        @JsonProperty("external_profile")
        private ExternalProfile externalProfile;
    }

    @Data
    public static class ExtAttr {
        private List<Attr> attrs;
    }

    @Data
    public static class ExternalProfile {
        @JsonProperty("external_corp_name")
        private String externalCorpName;
        @JsonProperty("wechat_channels")
        private WechatChannels wechatChannels;
        @JsonProperty("external_attr")
        private ExternalAttr externalAttr;
    }

    @Data
    public static class Attr {
        private Integer type;
        private String name;
        private Text text;
        private Web web;
    }

    @Data
    public static class WechatChannels {
        private String nickname;
        private Integer status;
    }

    @Data
    public static class ExternalAttr {
        private Integer type;
        private String name;
        private Text text;
        private Web web;
        @JsonProperty("miniprogram")
        private MiniProgram miniProgram;
    }

    @Data
    public static class Text {
        private String value;
    }

    @Data
    public static class Web {
        private String url;
        private String title;
    }

    @Data
    public static class MiniProgram {
        @JsonProperty("appid")
        private String appId;
        @JsonProperty("pagepath")
        private String pagePath;
        private String title;
    }
}

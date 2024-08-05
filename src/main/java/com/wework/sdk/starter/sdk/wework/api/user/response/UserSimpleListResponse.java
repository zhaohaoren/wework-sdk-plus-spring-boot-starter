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
public class UserSimpleListResponse extends WxApiBaseResponse {

    @JsonProperty("userlist")
    private List<User> userlist;

    @Data
    public static class User {
        @JsonProperty("userid")
        private String userid;
        private String name;
        private List<Integer> department;
        @JsonProperty("open_userid")
        private String openUserId;
    }
}

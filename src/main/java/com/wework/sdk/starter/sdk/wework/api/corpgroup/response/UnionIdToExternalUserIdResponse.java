package com.wework.sdk.starter.sdk.wework.api.corpgroup.response;

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
public class UnionIdToExternalUserIdResponse extends WxApiBaseResponse {

    @JsonProperty("external_userid_info")
    private List<externalUserId> externalUserIdInfo;

    @Data
    public static class externalUserId {
        @JsonProperty("corpid")
        private String corpId;
        @JsonProperty("external_userid")
        private String externalUserId;
    }
}

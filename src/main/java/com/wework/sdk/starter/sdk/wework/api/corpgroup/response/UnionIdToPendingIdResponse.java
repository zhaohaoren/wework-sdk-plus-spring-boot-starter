package com.wework.sdk.starter.sdk.wework.api.corpgroup.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhaohaoren
 */
@Getter
@Setter
public class UnionIdToPendingIdResponse extends WxApiBaseResponse {

    private List<IdItem> result;

    public static class IdItem {
        @JsonProperty("external_userid")
        private String externalUserId;
        @JsonProperty("pending_id")
        private String pendingId;
    }

}

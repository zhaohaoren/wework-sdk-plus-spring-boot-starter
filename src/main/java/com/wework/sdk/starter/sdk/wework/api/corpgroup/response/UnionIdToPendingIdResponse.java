package com.wework.sdk.starter.sdk.wework.api.corpgroup.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaohaoren
 */
@Getter
@Setter
public class UnionIdToPendingIdResponse extends WxApiBaseResponse {

    @JsonProperty("pending_id")
    private String pendingId;

}

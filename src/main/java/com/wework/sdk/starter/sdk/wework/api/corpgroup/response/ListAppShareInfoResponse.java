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
public class ListAppShareInfoResponse extends WxApiBaseResponse {

    @JsonProperty("corp_list")
    private List<Corp> corpList;

    @JsonProperty("next_cursor")
    private String nextCursor;

    @Data
    public static class Corp {
        @JsonProperty("corpid")
        private String corpId;
        @JsonProperty("corp_name")
        private String corpName;
        @JsonProperty("agentid")
        private String agentId;
    }
}

package com.wework.sdk.starter.sdk.wework.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * @author zhaohaoren
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WxApiBaseResponse {
    @JsonProperty("errcode")
    private Integer errCode;
    @JsonProperty("errmsg")
    private String errMsg;
}

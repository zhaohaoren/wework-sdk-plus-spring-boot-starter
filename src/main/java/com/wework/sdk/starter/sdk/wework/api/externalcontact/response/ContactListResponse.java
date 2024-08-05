package com.wework.sdk.starter.sdk.wework.api.externalcontact.response;

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
public class ContactListResponse extends WxApiBaseResponse {

    @JsonProperty("external_userid")
    private List<String> externalUserId;
}

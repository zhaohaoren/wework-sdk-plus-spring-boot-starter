package com.wework.sdk.starter.sdk.wework.api.corpgroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取应用共享信息
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/95813">...</a>
 */
@Data
@Slf4j
@Builder
public class ListAppShareInfoRequest implements WxApiBaseRequest<String> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/corpgroup/corp/list_app_share_info?access_token=";

    @JsonProperty("agentid")
    private Integer agentId;

    @JsonProperty("business_type")
    private Integer businessType;

    @JsonProperty("corpid")
    private String corpId;

    private Integer limit;

    private String cursor;

    @Override
    public String request(String token) throws TokenExpiredException {
        return "";
    }
}

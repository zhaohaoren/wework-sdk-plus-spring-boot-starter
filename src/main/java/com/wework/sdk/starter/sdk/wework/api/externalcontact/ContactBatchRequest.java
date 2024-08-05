package com.wework.sdk.starter.sdk.wework.api.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.externalcontact.response.ContactBatchResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 批量获取客户详情
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/92994">...</a>
 */
@Data
@Slf4j
@Builder
public class ContactBatchRequest extends WxApiBaseRequest<ContactBatchResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/batch/get_by_user?access_token=";

    @JsonProperty("userid_list")
    private List<String> userIdList;
    private String cursor;
    private Integer limit;

    @Override
    public ContactBatchResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.post(URL + token, this.corpRoute, this, new TypeReference<ContactBatchResponse>() {
        }, false);
    }
}

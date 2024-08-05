package com.wework.sdk.starter.sdk.wework.api.externalcontact;

import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.externalcontact.response.ContactDetailResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取客户详情
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/92114">...</a>
 */
@Data
@Slf4j
@Builder
public class ContactDetailRequest extends WxApiBaseRequest<ContactDetailResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/get?access_token=%s&external_userid=%s&cursor=%s";

    private String externalUserId;
    private String cursor;

    @Override
    public ContactDetailResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.get(String.format(URL, token, externalUserId, cursor), this.corpRoute, ContactDetailResponse.class);
    }
}

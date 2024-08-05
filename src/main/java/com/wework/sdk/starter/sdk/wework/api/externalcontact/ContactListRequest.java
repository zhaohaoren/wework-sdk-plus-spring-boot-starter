package com.wework.sdk.starter.sdk.wework.api.externalcontact;

import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.externalcontact.response.ContactListResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取客户列表
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/92113">...</a>
 */
@Data
@Slf4j
@Builder
public class ContactListRequest extends WxApiBaseRequest<ContactListResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/list?access_token=%s&userid=%s";

    private String userId;

    @Override
    public ContactListResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.get(String.format(URL, token, userId), this.corpRoute, ContactListResponse.class);
    }
}

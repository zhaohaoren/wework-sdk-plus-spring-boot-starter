package com.wework.sdk.starter.sdk.wework.api.externalcontact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 修改客户备注信息
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/92115">...</a>
 */
@Data
@Slf4j
@Builder
public class ContactRemarkRequest extends WxApiBaseRequest<WxApiBaseResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/externalcontact/remark?access_token=";

    @JsonProperty("userid")
    private String userId;
    @JsonProperty("external_userid")
    private String externalUserId;
    private String remark;
    private String description;
    @JsonProperty("remark_company")
    private String remarkCompany;
    @JsonProperty("remark_mobiles")
    private List<String> remarkMobiles;
    @JsonProperty("remark_pic_mediaid")
    private String remarkPicMediaId;

    @Override
    public WxApiBaseResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.post(URL + token, this.corpRoute, this, new TypeReference<WxApiBaseResponse>() {
        }, false);
    }
}

package com.wework.sdk.starter.sdk.wework.api.user;

import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.user.response.UserListResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取部门成员详情
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/90201">...</a>
 */
@Data
@Slf4j
@Builder
public class UserListRequest extends WxApiBaseRequest<UserListResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=%s&department_id=%s";

    private String departmentId;

    @Override
    public UserListResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.get(String.format(URL, token, departmentId), this.corpRoute, UserListResponse.class);
    }
}

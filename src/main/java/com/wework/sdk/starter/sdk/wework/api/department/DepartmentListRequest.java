package com.wework.sdk.starter.sdk.wework.api.department;

import com.wework.sdk.starter.sdk.util.WxSdkHttpUtil;
import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;
import com.wework.sdk.starter.sdk.wework.api.department.response.DepartmentListResponse;
import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 获取部门列表
 *
 * @author zhaohaoren
 * @see <a href="https://developer.work.weixin.qq.com/document/path/90208">...</a>
 */
@Data
@Slf4j
@Builder
public class DepartmentListRequest extends WxApiBaseRequest<DepartmentListResponse> {

    private final static String URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=%s&id=%s";

    private Integer departmentId;

    @Override
    public DepartmentListResponse request(String token) throws TokenExpiredException {
        return WxSdkHttpUtil.get(String.format(URL, token, departmentId), this.corpRoute, DepartmentListResponse.class);
    }
}

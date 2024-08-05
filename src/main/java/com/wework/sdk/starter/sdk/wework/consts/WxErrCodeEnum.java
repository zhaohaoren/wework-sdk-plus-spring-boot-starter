package com.wework.sdk.starter.sdk.wework.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhaohaoren
 */
@Getter
@AllArgsConstructor
public enum WxErrCodeEnum {


    /**
     * cookie过期了
     */
    COOKIE_OVERDUE(-3, "outsession"),

    /**
     * 新增：cookie过期，但请求结果是参数错误
     */
    COOKIE_PARAM_ERR(-30001, "参数错误"),

    /**
     * 没有错误
     */
    OK(0, "ok"),

    /**
     * token请求太频繁
     */
    TOKEN_FREQUENT(45033, "api concurrent out of limit"),

    /**
     * 不合法的access_token
     */
    TOKEN_INVALID(40014, "invalid access_token"),

    /**
     * 过期的access_token
     */
    TOKEN_EXPIRED(42001, "access_token expired"),

    /**
     * 群主已经解散群聊
     */
    GROUP_DISMISSED(49008, "group already dismissed"),

    /**
     * 企业主体被封！无法获取token
     */
    CORP_INVALID(40013, "invalid corpid");

    private final Integer errCode;
    private final String errMsg;

    public boolean equals(Integer errCode) {
        return this.errCode.equals(errCode);
    }

    public boolean equals(String errMsg) {
        return this.errMsg.equals(errMsg);
    }
}

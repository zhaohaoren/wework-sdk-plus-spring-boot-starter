package com.wework.sdk.starter.sdk.wework.api;


import com.wework.sdk.starter.sdk.wework.exception.TokenExpiredException;

/**
 * 微信API统一请求
 *
 * @author zhaohaoren
 */
public abstract class WxApiBaseRequest<T> {

    public String corpRoute;

    /**
     * 请求
     *
     * @return 结果
     * @throws TokenExpiredException token过期，需要外部去处理token过期的逻辑
     */
    public abstract T request(String token) throws TokenExpiredException;
}

package com.wework.sdk.starter.sdk.wework.exception;

/**
 * @author zhaohaoren
 */
public class CookieExpiredException extends Exception {

    public CookieExpiredException() {
        super("cookie无效或者已经过期！");
    }

    public CookieExpiredException(String message) {
        super(message);
    }
}

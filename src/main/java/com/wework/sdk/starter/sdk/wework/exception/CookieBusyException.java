package com.wework.sdk.starter.sdk.wework.exception;

/**
 * @author zhaohaoren
 */
public class CookieBusyException extends Exception {

    public CookieBusyException() {
        super("cookie请求太频繁！");
    }

    public CookieBusyException(String message) {
        super(message);
    }
}

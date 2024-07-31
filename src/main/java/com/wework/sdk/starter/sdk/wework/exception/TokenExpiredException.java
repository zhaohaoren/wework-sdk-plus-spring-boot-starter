package com.wework.sdk.starter.sdk.wework.exception;

/**
 * @author zhaohaoren
 */
public class TokenExpiredException extends Exception {

    public TokenExpiredException() {
        super("token无效或者已经过期！");
    }

    public TokenExpiredException(String message) {
        super(message);
    }
}

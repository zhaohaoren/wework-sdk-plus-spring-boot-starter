package com.wework.sdk.starter.sdk.wework.exception;

/**
 * @author zhaohaoren
 */
public class CorpBannedException extends Exception {

    public CorpBannedException() {
        super("企业主体已被封！");
    }

    public CorpBannedException(String message) {
        super(message);
    }
}

package com.wework.sdk.starter.sdk.wework.exception;

/**
 * @author zhaohaoren
 */
public class WxCorpInvalidException extends Exception {

    public WxCorpInvalidException(String message) {
        super(message);
    }

    public WxCorpInvalidException() {
        super("无效的corpId或企业主体被封!");
    }
}

package com.wework.sdk.starter.sdk.core;

import com.wework.sdk.starter.sdk.wework.api.WxApiBaseRequest;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaohaoren
 */
public class WeWorkClientConfig {

    Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();

}

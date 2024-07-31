package com.wework.sdk.starter.sdk.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author zhaohaoren
 */
@Slf4j
public class WxSdkHttpUtil {

    /**
     * 打印请求返回结果日志的时候最大的长度：部分请求结果信息太大
     */
    private static final int RESPONSE_MAX_LEN = 1000;
    /**
     * 序列化结果
     */
    public static ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    /**
     * GET 请求
     *
     * @param url       地址
     * @param headerMap header信息
     * @param paramMap  ?a=x&b=x信息
     * @param respClass 返回值类型
     * @param logPrint  是否需要打印日志
     * @param <T>       返回值类型
     * @return 请求结果
     */
    public static <T> T get(String url,
                            Map<String, String> headerMap,
                            Map<String, Object> paramMap,
                            Class<T> respClass,
                            Boolean logPrint) {
        String response = null;
        try {
            response = HttpRequest.get(url)
                    .headerMap(headerMap, true)
                    .form(paramMap)
                    .execute().body();
            if (logPrint) {
                log.info("response:=> {}", response);
            }
            return objectMapper.readValue(response, respClass);
        } catch (JsonProcessingException e) {
            log.info("请求结果转换失败, 请求结果为：{}", limitLog(response), e);
        }
        return null;
    }

    /**
     * POST 请求
     *
     * @param url           地址
     * @param body          请求体
     * @param typeReference 结果类型
     * @param logPrint      是否打印日志
     * @param <T>           返回值泛型类型
     * @param <B>           请求体对象类型
     * @return 请求结果
     */
    public static <T, B> T post(String url, B body, TypeReference<T> typeReference, Boolean logPrint) {
        String response = null;
        try {
            String requestBody = objectMapper.writeValueAsString(body);
            response = HttpUtil.post(url, requestBody);
            if (logPrint) {
                log.info("response:=> {}", response);
            }
            return objectMapper.readValue(response, typeReference);
        } catch (JsonProcessingException e) {
            log.info("请求结果转换失败, 结果为：{}", limitLog(response), e);
        }
        return null;
    }


    public static <T> T get(String url, Class<T> respClass) {
        return get(url, null, null, respClass, false);
    }

    public static <T> T get(String url, Map<String, String> headerMap, Class<T> respClass) {
        return get(url, headerMap, null, respClass, false);
    }


    private static String limitLog(String response) {
        if (StrUtil.isNotBlank(response) && response.length() > RESPONSE_MAX_LEN) {
            response = response.substring(0, RESPONSE_MAX_LEN);
        }
        return response;
    }
}

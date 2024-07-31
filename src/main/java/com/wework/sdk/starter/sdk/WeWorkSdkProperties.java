package com.wework.sdk.starter.sdk;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhaohaoren
 */
@Data
@ConfigurationProperties(prefix = WeWorkSdkProperties.PREFIX)
public class WeWorkSdkProperties {
    public static final String PREFIX = "wework.sdk";

    private static final String WE_WORK_DOMAIN = "https://qyapi.weixin.qq.com";

    private String proxyGatewayUrl;
}

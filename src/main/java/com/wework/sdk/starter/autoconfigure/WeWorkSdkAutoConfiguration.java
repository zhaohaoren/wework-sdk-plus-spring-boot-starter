package com.wework.sdk.starter.autoconfigure;

import com.wework.sdk.starter.sdk.WeWorkSdkProperties;
import com.wework.sdk.starter.sdk.core.WeWorkClientService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaohaoren
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(WeWorkSdkProperties.class)
public class WeWorkSdkAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = WeWorkSdkProperties.PREFIX, name = "proxy-gateway-url")
    public WeWorkClientService ewpSender(WeWorkSdkProperties properties) {
        return new WeWorkClientService();
    }

}

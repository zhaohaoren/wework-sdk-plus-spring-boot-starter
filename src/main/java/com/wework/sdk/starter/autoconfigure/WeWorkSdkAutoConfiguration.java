package com.wework.sdk.starter.autoconfigure;

import com.wework.sdk.starter.sdk.WeWorkSdkProperties;
import com.wework.sdk.starter.sdk.core.WeWorkClientProvider;
import com.wework.sdk.starter.sdk.core.WeWorkClientService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
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
    @ConditionalOnBean(WeWorkClientProvider.class)
    @ConditionalOnProperty(prefix = WeWorkSdkProperties.PREFIX, name = "proxy-gateway-url")
    public WeWorkClientService ewpSender(WeWorkSdkProperties properties, WeWorkClientProvider weWorkClientProvider) {
        return new WeWorkClientService(weWorkClientProvider);
    }

}

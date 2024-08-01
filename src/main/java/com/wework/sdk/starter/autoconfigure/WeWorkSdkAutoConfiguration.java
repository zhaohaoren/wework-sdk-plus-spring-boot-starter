package com.wework.sdk.starter.autoconfigure;

import com.wework.sdk.starter.sdk.WeWorkSdkProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaohaoren
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(WeWorkSdkProperties.class)
public class WeWorkSdkAutoConfiguration {


}

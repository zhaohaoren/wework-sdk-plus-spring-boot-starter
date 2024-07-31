package com.wework.sdk.starter.autoconfigure;

import com.wework.sdk.starter.sdk.WeWorkSdkProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.NoSuchProviderException;

/**
 * @author zhaohaoren
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(WeWorkSdkProperties.class)
public class WeWorkSdkAutoConfiguration {


    /**
     * LocalMailSender：springboot官方原生邮件发送器
     */
    @Bean
    @ConditionalOnProperty(prefix = WeWorkSdkProperties.PREFIX, name = localMailPrefix)
    LocalMailSender localSender(WeWorkSdkProperties properties) throws NoSuchProviderException {


        MailProperties.LocalMailSenderProperties localMailSenderProperties = properties.getLocalSender();
        // 加载JavaMailSender
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        applyLocalMailProperties(localMailSenderProperties, sender);
        // 创建LocalMailSender
        return new LocalMailSender(sender, templateEngine);
    }

}

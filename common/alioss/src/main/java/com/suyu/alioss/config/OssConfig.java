package com.suyu.alioss.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OssConfig {
    @Bean
    @ConfigurationProperties(prefix = "suyu.aliyun.oss")
    public OssParams ossParams() {
        return  new OssParams();
    }
}

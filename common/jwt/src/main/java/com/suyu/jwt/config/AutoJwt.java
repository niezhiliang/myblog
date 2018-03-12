package com.suyu.jwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Suyu
 * @Date: Created in 下午2:51 2018/2/6
 */
@Configuration
public class AutoJwt {

    @Bean
    @ConfigurationProperties(prefix = "jwt")
    public JwtParams jwtParams() {
        return new JwtParams();
    }
}

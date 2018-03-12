package com.suyu.jwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author Suyu
 * @Date: Created in 下午2:42 2018/2/6
 */
@Component
public class JwtParams {
    private String header = "Authorization";

    private String secret = "mySecret";

    private Long expiration = 604800l;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    @Bean
    @ConfigurationProperties(prefix = "jwt")
    public JwtParams jwt() {
        return new JwtParams();
    }
}

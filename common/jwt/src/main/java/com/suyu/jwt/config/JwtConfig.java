package com.suyu.jwt.config;

/**
 * @Author Suyu
 * @Date: Created in 下午3:02 2018/2/6
 */
public class JwtConfig {
    public static final String header = "Authorization";

    public static final String secret = "mySecret";

    public static final Long expiration = 604800l;
}

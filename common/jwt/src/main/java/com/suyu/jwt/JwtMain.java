package com.suyu.jwt;

import com.suyu.jwt.jwt.filter.JwtFilter;
import org.assertj.core.util.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

/**
 * @Author Suyu
 * @Date: Created in 上午9:17 2018/2/6
 */
@Configuration
//@Import({com.suyu.jwt.config.AutoJwt.class})
public class JwtMain {

    /** 注册JWT的拦截器 */
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        //添加需要拦截的url
        List<String> urlPatterns = Lists.newArrayList();
        urlPatterns.add("/check/*");
        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));
        return registrationBean;
    }
}

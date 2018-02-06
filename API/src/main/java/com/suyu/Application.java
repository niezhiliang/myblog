package com.suyu;

import com.suyu.jwt.JwtMain;
import com.suyu.jwt.jwt.filter.JwtFilter;
import org.assertj.core.util.Lists;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.suyu"})
@Import({com.suyu.Main.class,com.suyu.jwt.JwtMain.class})
@MapperScan(basePackages = "com.suyu.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}

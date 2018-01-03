package com.suyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.suyu"})
@Import({com.suyu.Main.class})
@MapperScan(basePackages = "com.suyu.mapper")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class);

    }
}

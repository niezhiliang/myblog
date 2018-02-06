package com.suyu.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Import({com.suyu.alioss.OssApp.class})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    /***
     * 配置上传的文件大小
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory config = new MultipartConfigFactory();
        config.setMaxFileSize("10MB");
        config.setMaxRequestSize("10MB");
        return config.createMultipartConfig();
    }
}

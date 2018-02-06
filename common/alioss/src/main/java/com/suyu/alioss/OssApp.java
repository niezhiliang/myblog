package com.suyu.alioss;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({com.suyu.alioss.config.OssConfig.class,com.suyu.alioss.util.OssUtil.class})
public class OssApp {
}

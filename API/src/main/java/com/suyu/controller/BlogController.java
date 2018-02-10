package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.entity.RestInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:26
 */
@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @RequestMapping(value = "/hotblog")
    public String blogHotOrder() {
        RestInfo restInfo = new RestInfo();

        return JSON.toJSONString(restInfo);
    }
}

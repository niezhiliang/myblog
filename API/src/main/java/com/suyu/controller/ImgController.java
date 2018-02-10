package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.ImgBlog;
import com.suyu.entity.InfoCode;
import com.suyu.entity.RestInfo;
import com.suyu.service.ImgBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/10 下午12:28
 */
@RestController
@RequestMapping(value = "img")
public class ImgController {
    @Autowired
    private ImgBlogService imgBlogService;

    @RequestMapping(value = "get")
    public String getimgs() {
        RestInfo restInfo = new RestInfo();
        List<ImgBlog> list = imgBlogService.getimgs();
        if (list != null) {
            restInfo.setCode(InfoCode.SUCCESS);
            restInfo.setContent(list);
        }
        return JSON.toJSONString(restInfo);
    }
}

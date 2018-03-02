package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.YouQing;
import com.suyu.entity.InfoCode;
import com.suyu.entity.RestInfo;
import com.suyu.service.YouQingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午9:29
 */
@RestController
@RequestMapping(value = "youqing")
public class YouQingController {

    @Autowired
    private YouQingService youQingService;


    @RequestMapping(value = "index")
    public String youQingIndex() {
        RestInfo restInfo = new RestInfo();
        List<YouQing> list = youQingService.selectYouQings();
        if (!list.isEmpty()) {
            restInfo.setContent(list);
            restInfo.setMessage("友情链接");
            restInfo.setCode(InfoCode.SUCCESS);
        }
        return JSON.toJSONString(restInfo);
    }
}

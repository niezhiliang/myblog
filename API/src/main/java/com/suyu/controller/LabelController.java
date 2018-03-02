package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.Label;
import com.suyu.entity.InfoCode;
import com.suyu.entity.RestInfo;
import com.suyu.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午7:54
 */
@RequestMapping(value = "label")
@RestController
public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping(value = "all")
    public String gettLabel() {
        RestInfo restInfo = new RestInfo();
        List<Label> labels = labelService.getLabels();
        if (!labels.isEmpty()) {
            restInfo.setCode(InfoCode.SUCCESS);
            restInfo.setContent(labels);
            restInfo.setMessage("信息如下");
        }
        return JSON.toJSONString(restInfo);
    }
}

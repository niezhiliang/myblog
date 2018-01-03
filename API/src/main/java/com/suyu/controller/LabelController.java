package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.Label;
import com.suyu.entity.InfoCode;
import com.suyu.entity.LabelCount;
import com.suyu.entity.ResInfo;
import com.suyu.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 查所有标签
     * @return
     */
    @RequestMapping(value = "getlabels")
    public String getlabels() {
        ResInfo resInfo = new ResInfo();
        List<Label> labels = labelService.selectLabelList();
        if (labels.size() > 0) {
            resInfo.setMessage("查询成功");
            resInfo.setCode(InfoCode.SUCCESS);
            resInfo.setContent(labels);
        } else {
            resInfo.setCode(InfoCode.SUCCESS);
            resInfo.setMessage("没有标签");
        }
        return JSON.toJSONString(resInfo);
    }

    /**
     * 查询所有的标签和文章数量
     * @return
     */
    @RequestMapping(value = "getlabelsandcount")
    public String getlabelsandcount() {
        ResInfo resInfo = new ResInfo();
        List<LabelCount> labelCounts = labelService.selectLabelsAndCount();
        if (labelCounts.size() > 0) {
            resInfo.setCode(InfoCode.SUCCESS);
            resInfo.setMessage("查询成功");
            resInfo.setContent(labelCounts);
        } else {
            resInfo.setCode(InfoCode.SUCCESS);
            resInfo.setMessage("还没有标签哦,亲!");
        }
        return JSON.toJSONString(resInfo);
    }
}

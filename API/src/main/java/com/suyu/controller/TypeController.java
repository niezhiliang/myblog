package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.Type;
import com.suyu.entity.InfoCode;
import com.suyu.entity.RestInfo;
import com.suyu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/3/3 下午3:45
 */
@RestController
@RequestMapping(value = "type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "all")
    public String index() {
        RestInfo restInfo = new RestInfo();
        List<Type> types = typeService.getAll();
        if (!types.isEmpty()) {
            restInfo.setCode(InfoCode.SUCCESS);
            restInfo.setMessage("类型如下");
            restInfo.setContent(types);
        }
        return JSON.toJSONString(restInfo);
    }
}

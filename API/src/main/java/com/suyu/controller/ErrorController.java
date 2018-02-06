package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.entity.InfoCode;
import com.suyu.entity.ResInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Suyu
 * @Date: Created in 下午5:17 2018/2/6
 */
@RestController
@RequestMapping("unchk/error")
public class ErrorController {

    @RequestMapping("/")
    public String error() {
        ResInfo resInfo = new ResInfo();
        resInfo.setCode(InfoCode.UNTOKEN);
        resInfo.setMessage("token过期或者无效，请重新登录");
        return JSON.toJSONString(resInfo);
    }
}

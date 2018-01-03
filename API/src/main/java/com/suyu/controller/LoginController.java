package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.User;
import com.suyu.entity.InfoCode;
import com.suyu.entity.ResInfo;
import com.suyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String login(@RequestBody User user){
        ResInfo resInfo = new ResInfo();
        if (user.getUsername() == null || "".equals(user.getUsername())) {
            resInfo.setMessage("用户名不能为空");
            resInfo.setCode(InfoCode.ERROR);
        }
        user = userService.selectByLogin(user);
       if (user != null) {
            resInfo.setCode(InfoCode.SUCCESS);
            resInfo.setContent(user);
            resInfo.setMessage("登录成功");
       } else {
           resInfo.setCode(InfoCode.ERROR);
           resInfo.setMessage("登录失败");
       }
       return JSON.toJSONString(resInfo);
    }

}
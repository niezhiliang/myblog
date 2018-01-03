package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.User;
import com.suyu.entity.BlogMain;
import com.suyu.entity.InfoCode;
import com.suyu.entity.ResInfo;
import com.suyu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserController {
   @Autowired
   private BlogService blogService;
   @Autowired
   private UserBlogService userBlogService;
   @Autowired
   private UserBrowseService userBrowseService;
   @Autowired
   private CommentService commentService;
   @Autowired
   private UserService userService;

   @RequestMapping(value = "blogleft")
   public String blogleft(@RequestBody User user) {
       ResInfo resInfo = new ResInfo();
       int blogs = blogService.selectBlogCount(new BlogMain());
       int visitCount = userBrowseService.selectAllCount();
       int comments = commentService.selectCommentCount();
       Map<String ,Object> map = new HashMap<String, Object>();
       map.put("blogcount",blogs);
       map.put("visitcount",visitCount);
       map.put("comments",comments);
       user = userService.selectByPrimaryKey(user.getId());
       user.setPassword("");
       map.put("user",user);
       resInfo.setCode(InfoCode.SUCCESS);
       resInfo.setContent(map);
       resInfo.setMessage("左侧信息如下");
       return JSON.toJSONString(resInfo);
   }
}

package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.Blog;
import com.suyu.entity.BlogMain;
import com.suyu.entity.BlogPublic;
import com.suyu.entity.InfoCode;
import com.suyu.entity.ResInfo;
import com.suyu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    /**
     * 查询博客列表
     * @return
     */
    @RequestMapping(value = "list")
    public String list(@RequestBody BlogMain blogMain) {
        ResInfo resInfo = new ResInfo();
        Map<String,Object> map = new HashMap<String,Object>();
        List<BlogMain> blogList = blogService.selectBlogList(blogMain);
        int count = blogService.selectBlogCount(blogMain);
        map.put("blogs",blogList);
        blogMain.setCount(count);
        map.put("count",count);
        map.put("currpage",blogMain.getPageno());
        map.put("pages",count%blogMain.getPagesize()==0? count/blogMain.getPagesize() : count/blogMain.getPagesize()+1);
        resInfo.setContent(map);
        resInfo.setCode(InfoCode.SUCCESS);
        return JSON.toJSONString(resInfo);
    }

    /**
     * 首页阅读排行榜
     * @return
     */
    @RequestMapping(value = "readorder")
    public String readorder() {
        ResInfo resInfo = new ResInfo();
        List<Blog> blogs = blogService.selectReadOrder();
        if(blogs.size() > 0) {
            resInfo.setCode(InfoCode.SUCCESS);
            resInfo.setContent(blogs);
            resInfo.setMessage("数据如下");
        } else {
            resInfo.setCode(InfoCode.SUCCESS);
            resInfo.setMessage("没有数据大哥");
        }
        return JSON.toJSONString(resInfo);
    }
    @RequestMapping(value = "pub")
    public String addBlog(@RequestBody BlogPublic blogPublic) {
        System.out.println(blogPublic);
        ResInfo resInfo = new ResInfo();
        resInfo.setMessage("hhaah");
        resInfo.setContent("123");
        resInfo.setCode(InfoCode.SUCCESS);
        return JSON.toJSONString(resInfo);
    }
}

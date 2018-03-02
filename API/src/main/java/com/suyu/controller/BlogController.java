package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.domain.Blog;
import com.suyu.domain.Label;
import com.suyu.domain.LabelBlog;
import com.suyu.entity.BlogParams;
import com.suyu.entity.BlogPublic;
import com.suyu.entity.InfoCode;
import com.suyu.entity.RestInfo;
import com.suyu.service.BlogLabelService;
import com.suyu.service.BlogService;
import com.suyu.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:26
 */
@RestController
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogLabelService blogLabelService;
    @Autowired
    private LabelService labelService;

    @RequestMapping(value = "/hotblog")
    public String blogHotOrder() {
        RestInfo restInfo = new RestInfo();
        List<Blog> blogs = blogService.getHotOrder();
        if (!blogs.isEmpty()) {
            restInfo.setContent(blogs);
            restInfo.setCode(InfoCode.SUCCESS);
            restInfo.setMessage("热门排行如下");
        }
        return JSON.toJSONString(restInfo);
    }

    @RequestMapping(value = "/newblog")
    public String blogNew() {
        RestInfo restInfo = new RestInfo();
        List<Blog> blogs = blogService.getNewOrder();
        if (!blogs.isEmpty()) {
            restInfo.setContent(blogs);
            restInfo.setCode(InfoCode.SUCCESS);
            restInfo.setMessage("最新发布如下");
        }
        return JSON.toJSONString(restInfo);
    }

    @RequestMapping(value = "index")
    public String blogIndex(@RequestBody BlogParams blogParams) {
        RestInfo restInfo = new RestInfo();
        List<Blog> blogs = blogService.indexBlog(blogParams);
        List<BlogPublic> blogPublicList = new ArrayList<BlogPublic>();
        for (Blog blog : blogs) {
            BlogPublic blogPublic = new BlogPublic();
            blogPublic.setBlog(blog);
            List<LabelBlog> labelBlogs = blogLabelService.selectByBlogId(blog.getId());
            List<String> types = new ArrayList<String>();
            for (LabelBlog label : labelBlogs) {
                List<Label> labels = labelService.getBlogByLabelId(label.getLid());
                types.add(labels.get(0).getLabelname());
            }
            blogPublic.setTypes(types);
            blogPublicList.add(blogPublic);
        }
        restInfo.setCode(InfoCode.SUCCESS);
        restInfo.setContent(blogPublicList);
        return JSON.toJSONString(restInfo);
    }

    @RequestMapping(value = "detail")
    public String geeBlogDetail(@RequestBody BlogParams blogParams) {
        RestInfo restInfo = new RestInfo();
        List<Blog> blogs = blogService.getBlogById(blogParams.getBid());
        if (!blogs.isEmpty()) {
            Blog blog = blogs.get(0);
            restInfo.setContent(blog);
            restInfo.setCode(InfoCode.SUCCESS);
        } else {
            restInfo.setMessage("不存在id为"+blogParams.getBid()+"的博客");
        }
        return JSON.toJSONString(restInfo);
    }
}

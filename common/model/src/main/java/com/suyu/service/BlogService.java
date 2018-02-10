package com.suyu.service;

import com.suyu.domain.Blog;
import com.suyu.entity.BlogResult;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:30
 */
public interface BlogService {

    public List<Blog> getHotOrder();

    public List<BlogResult> getBlogDetail(Long blogId);
}

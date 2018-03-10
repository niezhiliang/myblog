package com.suyu.service;

import com.suyu.domain.Blog;
import com.suyu.entity.BlogParams;
import com.suyu.entity.BlogPublicEntity;
import com.suyu.entity.BlogResult;
import com.suyu.entity.WebData;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:30
 */
public interface BlogService {

    public List<Blog> getHotOrder();

    public List<BlogResult> getBlogDetail(Long blogId);

    public List<Blog> getNewOrder();

    public List<Blog> indexBlog(BlogParams blogParams);

    public List<Blog> getBlogById(Long bid);

    public boolean publicBlog(BlogPublicEntity blogPublicEntity);

    public int addReadCount(Long bid);

    public List<Blog> orderByComment();

    WebData selectdata();

}

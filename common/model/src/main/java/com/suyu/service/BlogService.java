package com.suyu.service;

import com.suyu.domain.Blog;
import com.suyu.entity.BlogMain;

import java.util.List;

public interface BlogService {
    List selectBlogList(BlogMain blogMain);

    Integer selectBlogCount(BlogMain blogMain);

    Blog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Blog record);

    List<Blog> selectReadOrder();
}

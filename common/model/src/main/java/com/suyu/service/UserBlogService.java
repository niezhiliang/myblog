package com.suyu.service;


import com.suyu.domain.UserBlog;
import com.suyu.domain.UserBlogKey;

public interface UserBlogService {
    int insertSelective(UserBlog record);

    UserBlog selectByPrimaryKey(UserBlogKey key);

    int updateByPrimaryKeySelective(UserBlog record);

}

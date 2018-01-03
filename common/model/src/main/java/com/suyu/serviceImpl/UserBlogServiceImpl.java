package com.suyu.serviceImpl;

import com.suyu.domain.UserBlog;
import com.suyu.domain.UserBlogKey;
import com.suyu.mapper.UserBlogMapper;
import com.suyu.service.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBlogServiceImpl implements UserBlogService {
    @Autowired
    private UserBlogMapper userBlogMapper;
    @Override
    public int insertSelective(UserBlog record) {
        return userBlogMapper.insertSelective(record);
    }

    @Override
    public UserBlog selectByPrimaryKey(UserBlogKey key) {
        return userBlogMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(UserBlog record) {
        return userBlogMapper.updateByPrimaryKeySelective(record);
    }
}

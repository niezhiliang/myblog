package com.suyu.serviceImpl;

import com.suyu.domain.Blog;
import com.suyu.entity.BlogMain;
import com.suyu.mapper.BlogMapper;
import com.suyu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List selectBlogList(BlogMain blogMain) {
        return blogMapper.selectBlogList(blogMain);
    }

    @Override
    public Integer selectBlogCount(BlogMain blogMain) {
        return blogMapper.selectBlogCount(blogMain);
    }

    @Override
    public Blog selectByPrimaryKey(Long id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Blog record) {
        return blogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Blog> selectReadOrder() {
        return blogMapper.selectReadOrder();
    }
}

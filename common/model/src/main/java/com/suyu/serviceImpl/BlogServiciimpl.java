package com.suyu.serviceImpl;

import com.suyu.domain.Blog;
import com.suyu.entity.BlogResult;
import com.suyu.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:44
 */
@Service
@Transactional
public class BlogServiciimpl implements BlogService {
    @Override
    public List<Blog> getHotOrder() {
        return null;
    }

    @Override
    public List<BlogResult> getBlogDetail(Long blogId) {
        return null;
    }
}

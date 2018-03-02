package com.suyu.serviceImpl;

import com.suyu.domain.Blog;
import com.suyu.domain.BlogExample;
import com.suyu.entity.BlogParams;
import com.suyu.entity.BlogResult;
import com.suyu.mapper.BlogMapper;
import com.suyu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:44
 */
@Service
@Transactional
public class BlogServiciImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public List<Blog> getHotOrder() {
        BlogExample blogExample = new BlogExample();
        blogExample.setPageSize(5);
        blogExample.setStartRow(0);
        blogExample.setOrderByClause("readcount desc");
        return blogMapper.selectByExample(blogExample);
    }

    @Override
    public List<BlogResult> getBlogDetail(Long blogId) {
        return null;
    }

    @Override
    public List<Blog> getNewOrder() {
        BlogExample blogExample = new BlogExample();
        blogExample.setPageSize(5);
        blogExample.setStartRow(0);
        blogExample.setOrderByClause("createTime desc");
        return blogMapper.selectByExample(blogExample);
    }
    @Override
    public List<Blog> indexBlog(BlogParams blogParams) {
        BlogExample blogExample = new BlogExample();
        if (blogParams.getTitle() != null)  {
            blogExample.createCriteria().andTitleLike(blogParams.getTitle());
        }
        if (blogParams.getPageNo() != null && blogParams.getPageSize() != null) {
            blogExample.setStartRow((blogParams.getPageNo()-1)*blogParams.getPageSize());
            blogExample.setPageSize(blogParams.getPageSize());
        }
        return blogMapper.selectByExample(blogExample);
    }

    @Override
    public List<Blog> getBlogById(Long bid) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(bid);
        return blogMapper.selectByExample(blogExample);
    }
}

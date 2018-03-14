package com.suyu.serviceImpl;

import com.suyu.domain.Blog;
import com.suyu.domain.BlogExample;
import com.suyu.domain.Label;
import com.suyu.domain.LabelBlog;
import com.suyu.entity.*;
import com.suyu.mapper.BlogMapper;
import com.suyu.service.BlogLabelService;
import com.suyu.service.BlogService;
import com.suyu.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Autowired
    private BlogLabelService blogLabelService;

    @Autowired
    private LabelService labelService;


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
        blogExample.setPageSize(6);
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

    @Override
    public boolean publicBlog(BlogPublicEntity blogPublicEntity) {
        Blog blog = new Blog();
        blog.setTitle(blogPublicEntity.getTitle());
        blog.setResume(blogPublicEntity.getResume());
        blog.setContent(blogPublicEntity.getHtml());
        blog.setCreatetime(new Date());
        blog.setTid(Byte.parseByte(blogPublicEntity.getTypeId().toString()));
        blog.setUpdatetime(new Date());
        blog.setReadcount(0);
        blog.setComment(0);
        int num = blogMapper.insertSelective(blog);
        if (num > 0) {
            for (Long lid : blogPublicEntity.getSelected()) {
                LabelBlog labelBlog = new LabelBlog();
                labelBlog.setBid(blog.getId());
                labelBlog.setLid(lid);
                num = blogLabelService.insertSelective(labelBlog);
            }
            if (num > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int addReadCount(Long bid) {
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(bid);
        List<Blog> blogs  = blogMapper.selectByExample(blogExample);
        if (!blogs.isEmpty()) {
            Blog blog = blogs.get(0);
            blog.setReadcount(blog.getReadcount()+1);
            blogMapper.updateByPrimaryKeySelective(blog);
        }
        return 0;
    }

    @Override
    public List<Blog> orderByComment() {
        BlogExample blogExample = new BlogExample();
        blogExample.setPageSize(6);
        blogExample.setStartRow(0);
        blogExample.setOrderByClause("comment desc");
        return blogMapper.selectByExample(blogExample);
    }

    @Override
    public WebData selectdata() {

        return blogMapper.selectdata();
    }

    @Override
    public Integer getTotal(String title) {
        return blogMapper.getTotal(title);
    }

    @Override
    public List<BlogPublic> selectblogs(BlogPublic blogPublic) {
        List<BlogPublic> lists = blogMapper.selectblogs(blogPublic);
        for (BlogPublic blog : lists) {
            List<Label> labels = labelService.selectLabelName(blog.getId());
            blog.setTypes(labels);
        }
        return lists;
    }
}

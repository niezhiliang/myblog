package com.suyu.serviceImpl;

import com.suyu.domain.Blog;
import com.suyu.domain.BlogExample;
import com.suyu.domain.LabelBlog;
import com.suyu.entity.BlogParams;
import com.suyu.entity.BlogPublicEntity;
import com.suyu.entity.BlogResult;
import com.suyu.mapper.BlogMapper;
import com.suyu.service.BlogLabelService;
import com.suyu.service.BlogService;
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
}

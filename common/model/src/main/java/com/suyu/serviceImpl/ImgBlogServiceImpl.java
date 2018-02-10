package com.suyu.serviceImpl;

import com.suyu.domain.ImgBlog;
import com.suyu.domain.ImgBlogExample;
import com.suyu.mapper.ImgBlogMapper;
import com.suyu.service.ImgBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/10 下午12:20
 */
@Service
@Transactional
public class ImgBlogServiceImpl implements ImgBlogService {
    @Autowired
    private ImgBlogMapper imgBlogMapper;

    @Override
    public List<ImgBlog> getimgs() {
        ImgBlogExample imgBlogExample = new ImgBlogExample();
        imgBlogExample.createCriteria().andIsenabledNotEqualTo((byte)1);
        List<ImgBlog> imgBlogs = imgBlogMapper.selectByExample(imgBlogExample);
        return imgBlogs;
    }
}

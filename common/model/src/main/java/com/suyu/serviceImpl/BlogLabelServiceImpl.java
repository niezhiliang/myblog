package com.suyu.serviceImpl;

import com.suyu.domain.LabelBlog;
import com.suyu.domain.LabelBlogExample;
import com.suyu.mapper.LabelBlogMapper;
import com.suyu.service.BlogLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午8:32
 */
@Service
@Transactional
public class BlogLabelServiceImpl implements BlogLabelService {
    @Autowired
    private LabelBlogMapper labelBlogMapper;

    @Override
    public int insertSelective(LabelBlog record) {

        return labelBlogMapper.insertSelective(record);
    }

    @Override
    public List<LabelBlog> selectByBlogId(Long bid) {
        LabelBlogExample labelBlogExample = new LabelBlogExample();
        labelBlogExample.createCriteria().andBidEqualTo(bid);
        return labelBlogMapper.selectByExample(labelBlogExample);
    }


}

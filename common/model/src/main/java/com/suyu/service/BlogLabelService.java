package com.suyu.service;

import com.suyu.domain.LabelBlog;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午8:29
 */
public interface BlogLabelService {

    int insertSelective(LabelBlog record);

    List<LabelBlog> selectByBlogId(Long bid);

}

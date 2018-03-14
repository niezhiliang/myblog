package com.suyu.mapper;

import com.suyu.domain.Label;
import com.suyu.domain.LabelBlog;
import com.suyu.domain.LabelBlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabelBlogMapper {
    long countByExample(LabelBlogExample example);

    int deleteByExample(LabelBlogExample example);

    int deleteByPrimaryKey(Long bid);

    int insert(LabelBlog record);

    int insertSelective(LabelBlog record);

    List<LabelBlog> selectByExample(LabelBlogExample example);

    LabelBlog selectByPrimaryKey(Long bid);

    int updateByExampleSelective(@Param("record") LabelBlog record, @Param("example") LabelBlogExample example);

    int updateByExample(@Param("record") LabelBlog record, @Param("example") LabelBlogExample example);

    int updateByPrimaryKeySelective(LabelBlog record);

    int updateByPrimaryKey(LabelBlog record);

    Label selectLabelName(@Param("bid") Long bid);
}
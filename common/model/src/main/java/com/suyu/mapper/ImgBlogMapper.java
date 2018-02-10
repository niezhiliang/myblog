package com.suyu.mapper;

import com.suyu.domain.ImgBlog;
import com.suyu.domain.ImgBlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImgBlogMapper {
    long countByExample(ImgBlogExample example);

    int deleteByExample(ImgBlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImgBlog record);

    int insertSelective(ImgBlog record);

    List<ImgBlog> selectByExample(ImgBlogExample example);

    ImgBlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImgBlog record, @Param("example") ImgBlogExample example);

    int updateByExample(@Param("record") ImgBlog record, @Param("example") ImgBlogExample example);

    int updateByPrimaryKeySelective(ImgBlog record);

    int updateByPrimaryKey(ImgBlog record);
}
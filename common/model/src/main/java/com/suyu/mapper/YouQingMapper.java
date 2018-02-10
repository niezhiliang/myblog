package com.suyu.mapper;

import com.suyu.domain.YouQing;
import com.suyu.domain.YouQingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YouQingMapper {
    long countByExample(YouQingExample example);

    int deleteByExample(YouQingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YouQing record);

    int insertSelective(YouQing record);

    List<YouQing> selectByExample(YouQingExample example);

    YouQing selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YouQing record, @Param("example") YouQingExample example);

    int updateByExample(@Param("record") YouQing record, @Param("example") YouQingExample example);

    int updateByPrimaryKeySelective(YouQing record);

    int updateByPrimaryKey(YouQing record);
}
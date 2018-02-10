package com.suyu.mapper;

import com.suyu.domain.UserBrowse;
import com.suyu.domain.UserBrowseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBrowseMapper {
    long countByExample(UserBrowseExample example);

    int deleteByExample(UserBrowseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBrowse record);

    int insertSelective(UserBrowse record);

    List<UserBrowse> selectByExample(UserBrowseExample example);

    UserBrowse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBrowse record, @Param("example") UserBrowseExample example);

    int updateByExample(@Param("record") UserBrowse record, @Param("example") UserBrowseExample example);

    int updateByPrimaryKeySelective(UserBrowse record);

    int updateByPrimaryKey(UserBrowse record);
}
package com.suyu.service;

import com.suyu.domain.UserBrowse;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBrowseService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(UserBrowse record);

    UserBrowse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBrowse record);

    int selectAllCount();
}

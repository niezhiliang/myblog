package com.suyu.serviceImpl;

import com.suyu.domain.UserBrowse;
import com.suyu.mapper.UserBrowseMapper;
import com.suyu.service.UserBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBrowseServiceImpl implements UserBrowseService {
    @Autowired
    private UserBrowseMapper userBrowseMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userBrowseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserBrowse record) {
        return userBrowseMapper.insertSelective(record);
    }

    @Override
    public UserBrowse selectByPrimaryKey(Long id) {
        return userBrowseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserBrowse record) {
        return userBrowseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int selectAllCount() {
        return userBrowseMapper.selectAllCount();
    }
}

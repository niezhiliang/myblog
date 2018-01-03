package com.suyu.service;

import com.suyu.domain.Comment;

public interface CommentService {
    int updateByPrimaryKeySelective(Comment record);

    int insertSelective(Comment record);

    int deleteByPrimaryKey(Long id);

    int selectCommentCount();
}

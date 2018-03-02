package com.suyu.service;

import com.suyu.domain.YouQing;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午9:24
 */
public interface YouQingService {
    int insertSelective(YouQing record);

    List<YouQing> selectYouQings();

    int updateByPrimaryKeySelective(YouQing record);
}

package com.suyu.service;

import com.suyu.domain.Label;
import com.suyu.entity.LabelCount;

import java.util.List;

public interface LabelService {

    int insertSelective(Label record);

    int deleteByPrimaryKey(Long id);

    List<Label> selectLabelList();

    List<LabelCount> selectLabelsAndCount();
}

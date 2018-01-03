package com.suyu.serviceImpl;

import com.suyu.domain.Label;
import com.suyu.entity.LabelCount;
import com.suyu.mapper.LabelMapper;
import com.suyu.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;
    @Override
    public int insertSelective(Label record) {
        return labelMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return labelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Label> selectLabelList() {
        return labelMapper.selectLabelList();
    }

    @Override
    public List<LabelCount> selectLabelsAndCount() {
        return labelMapper.selectLabelsAndCount();
    }
}

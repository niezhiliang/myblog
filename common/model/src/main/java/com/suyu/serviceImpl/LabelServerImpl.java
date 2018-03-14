package com.suyu.serviceImpl;

import com.suyu.domain.Label;
import com.suyu.domain.LabelExample;
import com.suyu.mapper.LabelMapper;
import com.suyu.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午7:48
 */
@Service
@Transactional
public class LabelServerImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<Label> getLabels() {
        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andIdIsNotNull();
        return labelMapper.selectByExample(labelExample);
    }

    @Override
    public List<Label> getBlogByLabelId(Long lid) {
        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andIdEqualTo(lid);
        return labelMapper.selectByExample(labelExample);
    }

    @Override
    public List<Label> selectLabelName(Long bid) {
        return labelMapper.selectLabelName(bid);
    }
}

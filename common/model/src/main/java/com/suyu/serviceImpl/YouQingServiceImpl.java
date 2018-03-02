package com.suyu.serviceImpl;

import com.suyu.domain.YouQing;
import com.suyu.domain.YouQingExample;
import com.suyu.mapper.YouQingMapper;
import com.suyu.service.YouQingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午9:25
 */
@Service
@Transactional
public class YouQingServiceImpl implements YouQingService {
    @Autowired
    private YouQingMapper youQingMapper;
    @Override
    public int insertSelective(YouQing record) {
        return 0;
    }

    @Override
    public List<YouQing> selectYouQings() {
        YouQingExample youQingExample = new YouQingExample();
        youQingExample.createCriteria().andIsenableEqualTo((byte)0);
        return youQingMapper.selectByExample(youQingExample);
    }

    @Override
    public int updateByPrimaryKeySelective(YouQing record) {
        return 0;
    }
}

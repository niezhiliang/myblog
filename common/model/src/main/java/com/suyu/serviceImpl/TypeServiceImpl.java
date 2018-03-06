package com.suyu.serviceImpl;

import com.suyu.domain.Type;
import com.suyu.domain.TypeExample;
import com.suyu.mapper.TypeMapper;
import com.suyu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/3/3 下午3:48
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> getAll() {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria().andIdIsNotNull();
        return typeMapper.selectByExample(typeExample);
    }
}

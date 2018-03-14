package com.suyu.service;

import com.suyu.domain.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:40
 */
public interface LabelService {
    public List<Label> getLabels();

    public List<Label> getBlogByLabelId(Long lid);

    public List<Label> selectLabelName(Long bid);
}

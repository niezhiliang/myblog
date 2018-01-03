package com.suyu.entity;

public class LabelCount {

    /**
     * 标签id
     */
    private Long lid;
    /**
     *标签名称
     */
    private String labelname;
    /**
     * 文章数量
     */
    private Integer count;

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

package com.suyu.entity;

import java.util.Date;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/2/9 上午11:34
 */
public class BlogResult {
    private Long bid;

    private String title;

    private Date CredateAt;

    private Integer readCount;

    private Integer comuniteCount;

    private String shortInfo;

    private List<String> labels;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCredateAt() {
        return CredateAt;
    }

    public void setCredateAt(Date credateAt) {
        CredateAt = credateAt;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getComuniteCount() {
        return comuniteCount;
    }

    public void setComuniteCount(Integer comuniteCount) {
        this.comuniteCount = comuniteCount;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}

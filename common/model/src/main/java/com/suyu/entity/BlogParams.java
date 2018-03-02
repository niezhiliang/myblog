package com.suyu.entity;

/**
 * @Author Suyu
 * @Date 2018/2/28 上午8:40
 */
public class BlogParams {
    /**
     * 博客ID
     */
    private Long bid;

    /**
     * 标签ID
     */
    private Long lid;
    /**
     * 博客标题
     */
    private String title;

    /**
     * 分页当前页
     */
    private Integer pageNo;

    /**
     * 分页大小
     */
    private Integer pageSize;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

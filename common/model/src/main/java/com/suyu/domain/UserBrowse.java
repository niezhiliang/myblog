package com.suyu.domain;

public class UserBrowse {
    private Long id;

    private Long uid;

    private Long bid;

    private String viewtime;

    private String ip;

    private Integer duringtime;

    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getViewtime() {
        return viewtime;
    }

    public void setViewtime(String viewtime) {
        this.viewtime = viewtime == null ? null : viewtime.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getDuringtime() {
        return duringtime;
    }

    public void setDuringtime(Integer duringtime) {
        this.duringtime = duringtime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
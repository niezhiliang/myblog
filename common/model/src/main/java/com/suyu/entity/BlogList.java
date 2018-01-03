package com.suyu.entity;

import java.util.Date;

public class BlogList {
    /**
     * 博客编号
     */
    private long id;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 简介
     */
    private String resume;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date creattime;
    /**
     * 阅读数量
     */
    private int readcount;
    /**
     * 评论数量
     */
    private int comment;
    /**
     * 博客类型 0.新 1. 热
     */
    private byte type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}

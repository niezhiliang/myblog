package com.suyu.entity;

import java.util.Date;
import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/3/10 上午10:01
 */
public class BlogResume {
    /**文章类型**/
    private String typename;

    /**文章id**/
    private Long bid;

    /**文章标题**/
    private String title;

    /**作者*/
    private String author;

    /**创建时间**/
    private Date createAt;

    /**浏览量**/
    private Integer readcount;

    /**评论**/
    private Integer comment;

    /**文章简介**/
    private String resume;
    /**文章标签**/
    private List<String> labels;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}

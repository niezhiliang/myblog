package com.suyu.entity;

/**
 * @Author Suyu
 * @Date 2018/3/10 上午10:53
 */
public class WebData {

    /**博客总数**/
    private Integer blogcount;

    /**阅读总数**/
    private Integer readcount;

    /**评论总数**/
    private Integer commentcount;

    /**当前在线**/
    private Integer onlinecount = 1;

    public Integer getBlogcount() {
        return blogcount;
    }

    public void setBlogcount(Integer blogcount) {
        this.blogcount = blogcount;
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public Integer getOnlinecount() {
        return onlinecount;
    }

    public void setOnlinecount(Integer onlinecount) {
        this.onlinecount = onlinecount;
    }
}

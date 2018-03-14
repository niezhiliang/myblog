package com.suyu.entity;

import com.suyu.domain.Blog;
import com.suyu.domain.Label;

import java.util.Date;
import java.util.List;

public class BlogPublic {
    /**博客id**/
    private Long id;
    /**博客标题**/
    private String title;
    /**摘要**/
    private String resume;
    /**正文**/
    private String content;
    /**分类型**/
    private List<Label> types;
    /**创建时间**/
    private Date createTime;
    /**阅读量**/
    private Integer readcount;
    /**评论**/
    private Integer comment;
    /**博客类型**/
    private String blogType;

    private Blog blog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    private Integer count;

    private Integer pageno = 1;

    private Integer pagesize = 6;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
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

    @Override
    public String toString() {
        return "BlogPublic{" +
                "title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", content='" + content + '\'' +
                ", types=" + types +
                '}';
    }

    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public List<Label> getTypes() {
        return types;
    }

    public void setTypes(List<Label> types) {
        this.types = types;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = (pageno-1)*this.pagesize;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
}

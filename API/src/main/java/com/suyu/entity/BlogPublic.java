package com.suyu.entity;

import com.suyu.domain.Blog;
import java.util.List;

public class BlogPublic {
    /**博客标题**/
    private String title;
    /**摘要**/
    private String resume;
    /**正文**/
    private String content;
    /**分类型**/
    private List<String> types;

    private String blogType;

    private Blog blog;

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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}

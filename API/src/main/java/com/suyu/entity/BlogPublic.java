package com.suyu.entity;

import java.util.List;

public class BlogPublic {
    /**博客标题**/
    private String title;
    /**摘要**/
    private String resume;
    /**正文**/
    private String content;
    /**分类型**/
    private List<Object> types;

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

    public List<Object> getTypes() {
        return types;
    }

    public void setTypes(List<Object> types) {
        this.types = types;
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
}

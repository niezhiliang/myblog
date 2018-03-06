package com.suyu.entity;

import java.util.List;

/**
 * @Author Suyu
 * @Date 2018/3/5 下午3:04
 */
public class BlogPublicEntity {
    /**文章类型**/
    private Long typeId;

    /**文章标题**/
    private String title;

    /**文章简介**/
    private String resume;

    /**markdown翻译的html**/
    private String html;

    /**原生的markdown的代码**/
    private String markdown;

    /**文章的选中类型**/
    private List<Long> selected;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public List<Long> getSelected() {
        return selected;
    }

    public void setSelected(List<Long> selected) {
        this.selected = selected;
    }
}

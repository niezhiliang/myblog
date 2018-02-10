package com.suyu.domain;

public class ImgBlog {
    private Long id;

    private String title;

    private String url;

    private Byte order;

    private Byte isenabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Byte getOrder() {
        return order;
    }

    public void setOrder(Byte order) {
        this.order = order;
    }

    public Byte getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(Byte isenabled) {
        this.isenabled = isenabled;
    }
}
package com.suyu.domain;

import java.util.Date;

public class Notice {
    private Integer id;

    private String content;

    private String url;

    private Date beginat;

    private Date endat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getBeginat() {
        return beginat;
    }

    public void setBeginat(Date beginat) {
        this.beginat = beginat;
    }

    public Date getEndat() {
        return endat;
    }

    public void setEndat(Date endat) {
        this.endat = endat;
    }
}
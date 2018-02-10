package com.suyu.domain;

import java.util.Date;

public class Type {
    private Long id;

    private String blogtype;

    private Byte isenable;

    private Date createat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogtype() {
        return blogtype;
    }

    public void setBlogtype(String blogtype) {
        this.blogtype = blogtype == null ? null : blogtype.trim();
    }

    public Byte getIsenable() {
        return isenable;
    }

    public void setIsenable(Byte isenable) {
        this.isenable = isenable;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }
}
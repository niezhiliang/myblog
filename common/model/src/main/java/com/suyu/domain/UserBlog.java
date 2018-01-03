package com.suyu.domain;

public class UserBlog extends UserBlogKey {
    private Byte istop;

    private Boolean type;

    public Byte getIstop() {
        return istop;
    }

    public void setIstop(Byte istop) {
        this.istop = istop;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
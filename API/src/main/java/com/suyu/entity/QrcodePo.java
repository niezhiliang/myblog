package com.suyu.entity;

/**
 * @Author Suyu
 * @Date 2018/3/14 下午4:26
 */
public class QrcodePo {
    private String userid;

    private String base64code;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBase64code() {
        return base64code;
    }

    public void setBase64code(String base64code) {
        this.base64code = base64code;
    }
}

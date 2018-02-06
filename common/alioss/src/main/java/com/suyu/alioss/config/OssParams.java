package com.suyu.alioss.config;

import org.springframework.stereotype.Component;

@Component
public class OssParams {

    private String accessKeyId;

    private String accessKeySecret;

    private String endpoint;

    private String Bucket;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return Bucket;
    }

    public void setBucket(String bucket) {
        Bucket = bucket;
    }

    @Override
    public String toString() {
        return "OssParams{" +
                "accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", Bucket='" + Bucket + '\'' +
                '}';
    }
}

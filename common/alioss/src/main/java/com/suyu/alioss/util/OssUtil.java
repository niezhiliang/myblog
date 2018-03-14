package com.suyu.alioss.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.suyu.alioss.config.OssParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

@Component
public class OssUtil {
    @Autowired
    private OssParams ossParams;

    private static OssParams params = new OssParams();

    private  OSSClient ossClient = null;

    private  void connect() {
        if (ossParams == null) {
            ossParams = params;
        }
        System.out.println(ossParams);
        ossClient = new OSSClient(ossParams.getEndpoint() , ossParams.getAccessKeyId() ,ossParams.getAccessKeySecret());
    }

    private static OssUtil ossUtil;

    @PostConstruct
    public void init() {
        ossUtil = this;
        ossUtil.params = this.ossParams;
    }
    /**
     *
     OssUtil ossUtil = new OssUtil();
     ossUtil.uploadFile("test/test2.docx" , new File("./data/test0.docx"));
     * @param key
     * @param file
     */
    public void upload(File file,String key) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.putObject(ossParams.getBucket() , key , file);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }

    /**
     * OssUtil ossUtil = new OssUtil();
     ossUtil.uploadFile(map);
     * @param map key:oss的key    value:上传的文件对象
     */
    public void uploadManyFile(Map<String,File> map) {
        if (ossClient == null) {
            connect();
        }
        try {
            for (String key :map.keySet()) {
                ossClient.putObject(ossParams.getBucket() , key , map.get(key));
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }


    /**
     *
     OssUtil ossUtil = new OssUtil();
     ossUtil.downloadFile("test/test0.docx" , new File("./data/download.docx"));
     * @param key
     * @param file
     */
    public void download(File file ,String key) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.getObject(new GetObjectRequest(ossParams.getBucket() , key) , file);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }


    /**
     * 流上传到OSS
     * @param key 路径
     * @param inputStream  文件流
     */
    public void upload(String key , InputStream inputStream) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.putObject(ossParams.getBucket() , key , inputStream);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }
    /**
     * byte[]数组上传到OSS
     * @param key 路径
     * @param bytes  byte数组
     */
    public void upload(String key , byte[] bytes) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.putObject(ossParams.getBucket() , key , new ByteArrayInputStream(bytes));
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }

    /**
     * 文件删除
     * @param key
     */
    public void deleteFile(String key) {
        if (ossClient == null) {
            connect();
        }
        try {
            ossClient.deleteObject(ossParams.getBucket(), key);
        } catch (ClientException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
            ossClient = null;
        }
    }
}

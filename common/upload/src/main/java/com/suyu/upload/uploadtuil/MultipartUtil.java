package com.suyu.upload.uploadtuil;

import com.suyu.alioss.config.OssParams;
import com.suyu.alioss.util.OssUtil;
import com.suyu.upload.entity.FileOpea;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class MultipartUtil {
    private static  final Logger logger = Logger.getLogger(MultipartUtil.class);

    @Autowired
    private OssUtil ossUtil;
    @Autowired
    private OssParams ossParams;
    private final static String OSS_PATH = "http://huluwa-pdf.oss-cn-qingdao.aliyuncs.com/";
    /**
     * 文件上传到本地
     * @param file
     * @return
     */
    public FileOpea fileUpload (MultipartFile file, String path) {
        FileOpea fileOpea = new FileOpea();
        try {
            InputStream inputStream = file.getInputStream();
            //获取文件名称
            String fileName = file.getOriginalFilename();
            fileOpea.setName(fileName);
            fileOpea.setSize(file.getSize());
            // 获取文件的后缀名
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            fileOpea.setSuffix(fileType);
            fileName = System.currentTimeMillis()+fileType;
            fileOpea.setOssname(fileName);
            //File local_file = new File(path+fileName);
            int index;
            byte[] bytes = new byte[1024];
            FileOutputStream downloadFile = new FileOutputStream(path+fileName);
            fileOpea.setOss_path(path+fileName);
            while ((index = inputStream.read(bytes)) != -1) {
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            downloadFile.close();
            inputStream.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return fileOpea;
    }

    /**
     * 文件上传到oss
     */
    public FileOpea ossFileUpload (MultipartFile file, String path) {
        FileOpea fileOpea = new FileOpea();
        try {
            InputStream inputStream = file.getInputStream();
            //获取文件名称
            String fileName = file.getOriginalFilename();
            fileOpea.setName(fileName);
            fileOpea.setSize(file.getSize());
            // 获取文件的后缀名
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            fileOpea.setSuffix(fileType);
            fileName = System.currentTimeMillis()+fileType;
            fileOpea.setOssname(fileName);
            ossUtil.upload(path+fileName,inputStream);
            String osspath = ossParams.getEndpoint().replace("//","//"+ossParams.getBucket()+".")+"/"+path+fileName;
            fileOpea.setOss_path(osspath);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return fileOpea;
    }
}

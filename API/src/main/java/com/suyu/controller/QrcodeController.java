package com.suyu.controller;

import com.alibaba.fastjson.JSON;
import com.suyu.alioss.config.OssParams;
import com.suyu.alioss.util.OssUtil;
import com.suyu.entity.FileOpea;
import com.suyu.entity.InfoCode;
import com.suyu.entity.QrcodePo;
import com.suyu.entity.RestInfo;
import com.suyu.server.SocketServer;
import com.suyu.util.Base64toImg;
import com.suyu.util.ImgUtil;
import com.suyu.util.ThumbnailatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @Author Suyu
 * @Date 2018/3/13 下午5:14
 */
@RestController
@RequestMapping(value = "qrcode")
public class QrcodeController {
    @Autowired
    private OssUtil ossUtil;
    @Autowired
    private OssParams ossParams;

    private static final String osspath = "http://suyublog.oss-cn-hangzhou.aliyuncs.com/";

    /**上传base64到oss**/
    @RequestMapping(value = "base64upload")
    public String qrcodesign(@RequestBody QrcodePo qrcodePo) {
        RestInfo restInfo = new RestInfo();
        if(qrcodePo.getUserid() == null || qrcodePo.getBase64code() == null) {
            restInfo.setCode(InfoCode.ERROR);
            restInfo.setMessage("用户名和base64都必传");
        } else {
            //这里主要是为了url转码用
            String code = qrcodePo.getBase64code().replace(' ','+');
            restInfo = fileupload(code);
        }
        SocketServer.sendMessage(restInfo.getContent().toString(),qrcodePo.getUserid());
        return JSON.toJSONString(restInfo);
    }

    /**
     * 文件上传
     * @param
     * @return
     */
    public RestInfo fileupload (String code) {
        OssUtil ossUtil = new OssUtil();
        FileOpea fileOpea = new FileOpea();
        RestInfo respInfo = new RestInfo();
        String oss_file_path ="person/sign/" ;
        String fileType = ".png";
        byte [] bytes = Base64toImg.GenerateByte(code);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage =  ImgUtil.spin(270,bytes);
            bufferedImage = ThumbnailatorUtils.ImgBufferedImage(bufferedImage,"D:/sign",300,150,"test.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", os);
            InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
            fileOpea.setSuffix(fileType);
            String fileName = System.currentTimeMillis()+new Random().nextInt(123456)+fileType;
            fileOpea.setOssname(fileName);
            oss_file_path += fileName;
            ossUtil.upload(oss_file_path,inputStream);
            fileOpea.setOss_path(osspath+"/"+oss_file_path);
            respInfo.setContent(fileOpea.getOss_path());
            respInfo.setCode(InfoCode.SUCCESS);
        } catch (IOException e) {
            respInfo.setCode(InfoCode.ERROR);
        }
        return respInfo;
    }
}

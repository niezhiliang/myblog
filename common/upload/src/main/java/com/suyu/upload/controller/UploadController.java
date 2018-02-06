package com.suyu.upload.controller;

import com.suyu.upload.entity.FileOpea;
import com.suyu.upload.uploadtuil.MultipartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "admincheck")
public class UploadController {
    @Autowired
    private MultipartUtil multipartUtil;
    private String path = "/Users/suyu/Public/work/person/multipart-file-upload/";

    @RequestMapping(value = "uploadimg")
    public String upload(@RequestParam("file") MultipartFile file) {
        /**********上传到本地begin***************/
        //FileOpea fileOpea = multipartUtil.fileUpload(file,path);
        /***********上传到本地end****************/

        /************上传到osss  begin************************/
        FileOpea fileOpea = multipartUtil.ossFileUpload(file,"office/");
        /************上传到osss  end**************************/
        return fileOpea.getOssname();
    }

}

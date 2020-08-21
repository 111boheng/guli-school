package com.guli.oss.controller;

import com.guli.commonutils.R;
import com.guli.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;
    @PostMapping("/upload")
    public R fileUpload(MultipartFile file){
        System.out.println(file);
        String url = ossService.uploadFile(file);
        return R.ok().data("url",url);
    }
}

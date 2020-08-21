package com.guli.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;
import com.guli.oss.service.OssService;
import com.guli.oss.utils.ConstantPropertiesUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.ConstantCallSite;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFile(MultipartFile multipartFile) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。

        String endpoint = ConstantPropertiesUtils.END_POINT;
// Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String backetName = ConstantPropertiesUtils.BACKET_NAME;

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
        InputStream inputStream = null;
        String url = "";
        try {
            inputStream = multipartFile.getInputStream();
            // 获取文件名称;
            String filename = multipartFile.getOriginalFilename();
            // 为相同的文件添加uuid字符区分，避免相同的文件名覆盖问题
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename = uuid+filename;
            // 把文件按照时间分类  2020/8/20
            // 获取当前日期
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String filePath = simpleDateFormat.format(date);
            filename = filePath + "/" + filename;

            ossClient.putObject(backetName, filename, inputStream);
            url = "https://hengheng-1010.oss-cn-beijing.aliyuncs.com/"+filename;
            // 关闭OSSClient。
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            ossClient.shutdown();
        }


        return url;
    }
}

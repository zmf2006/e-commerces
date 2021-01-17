package com.fh.ecommerce.controller;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.fh.ecommerce.uitl.CommonsReturn;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("fileUpload")
public class FileUploadController {

    @RequestMapping("uploadFile")
    public CommonsReturn uploadFile(MultipartFile file){
        try {
            // Endpoint以杭州为例，其它Region请按实际情况填写。
            String endpoint = "oss-cn-beijing.aliyuncs.com";
            // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
            String accessKeyId = "LTAI4GBcJwqJtZdHbAcueyYm";
            String accessKeySecret = "EJjMY4rc3sRA7gtOK0sDfo3oOtHrw4";
            String filename = file.getOriginalFilename();
            System.out.println(filename);
            String houzhui = filename.substring(filename.lastIndexOf("."));
            String newFileName= UUID.randomUUID().toString()+houzhui;

            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 上传文件流。
            InputStream inputStream = file.getInputStream();
            ossClient.putObject("1912zmf", newFileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            return CommonsReturn.success("https://1912zmf.oss-cn-beijing.aliyuncs.com/"+newFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("deleteFile")
    public static void deleteFile(String file){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4GBcJwqJtZdHbAcueyYm";
        String accessKeySecret = "EJjMY4rc3sRA7gtOK0sDfo3oOtHrw4";
        String bucketName = "1912zmf";
        String filename = file.substring(file.lastIndexOf("/")+1);
        String objectName = filename;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 删除文件。如需删除文件夹，请将ObjectName设置为对应的文件夹名称。如果文件夹非空，则需要将文件夹下的所有object删除后才能删除该文件夹。
        ossClient.deleteObject(bucketName, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }


}

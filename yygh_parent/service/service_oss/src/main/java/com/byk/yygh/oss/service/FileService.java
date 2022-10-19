package com.byk.yygh.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author byk
 */
public interface FileService {

    //上传文件到阿里云oss
    String upload(MultipartFile file);
}

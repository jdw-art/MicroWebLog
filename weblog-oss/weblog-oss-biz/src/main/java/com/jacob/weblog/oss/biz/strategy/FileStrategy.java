package com.jacob.weblog.oss.biz.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Jacob
 * @Description: 文件策略接口
 * @Date: 2024-07-20 21:39
 * @Version: 1.0
 */
public interface FileStrategy {

    /**
     * 文件上传
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

}
package com.jacob.weblog.oss.biz.service;

import com.jacob.weblog.framework.common.response.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Jacob
 * @Description: 文件业务接口
 * @Date: 2024-07-20 21:54
 * @Version: 1.0
 */
public interface FileService {

    /**
     * 文件上传
     * @param file
     * @return
     */
    Response<?> uploadFile(MultipartFile file);
}

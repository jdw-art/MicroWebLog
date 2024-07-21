package com.jacob.weblog.oss.biz.service.impl;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.oss.biz.model.UploadFileRspVO;
import com.jacob.weblog.oss.biz.service.FileService;
import com.jacob.weblog.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2024-07-20 21:55
 * @Version: 1.0
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件到
        String url = fileStrategy.uploadFile(file);

        return Response.success(UploadFileRspVO.builder().url(url).build());
    }
}

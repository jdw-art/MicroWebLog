package com.jacob.weblog.oss.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Jacob
 * @Description: Aliyun 配置类
 * @Date: 2024-07-20 22:19
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "storage.aliyun-oss")
@Component
@Data
public class AliyunOSSProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}

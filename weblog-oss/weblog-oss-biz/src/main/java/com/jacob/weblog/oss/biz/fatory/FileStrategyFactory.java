package com.jacob.weblog.oss.biz.fatory;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.jacob.weblog.oss.biz.strategy.FileStrategy;
import com.jacob.weblog.oss.biz.strategy.impl.AliyunOSSFileStrategy;
import com.jacob.weblog.oss.biz.strategy.impl.MinioFileStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jacob
 * @Description: 文件上传工厂
 * @Date: 2024-07-20 21:47
 * @Version: 1.0
 */
@Configuration
@RefreshScope
public class FileStrategyFactory {

    @Value("${storage.type}")
    private String strategyType;

    @Bean
    @RefreshScope
    public FileStrategy getFileStrategy() {
        if (StringUtils.equals(strategyType, "minio")) {
            return new MinioFileStrategy();
        } else if (StringUtils.equals(strategyType, "aliyun")) {
            return new AliyunOSSFileStrategy();
        }
        throw new IllegalArgumentException("不可用存储类型");
    }
}

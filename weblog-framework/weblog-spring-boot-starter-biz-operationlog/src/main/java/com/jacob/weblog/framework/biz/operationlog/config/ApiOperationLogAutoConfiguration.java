package com.jacob.weblog.framework.biz.operationlog.config;

import com.jacob.weblog.framework.biz.operationlog.aspect.ApiOperationLogAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Jacob
 * @Description: API 操作日志记录自动配置类
 * @Date: 2024-07-19 20:53
 * @Version: 1.0
 */
@AutoConfiguration
public class ApiOperationLogAutoConfiguration {

    @Bean
    public ApiOperationLogAspect apiOperationLogAspect() {
        return new ApiOperationLogAspect();
    }
}
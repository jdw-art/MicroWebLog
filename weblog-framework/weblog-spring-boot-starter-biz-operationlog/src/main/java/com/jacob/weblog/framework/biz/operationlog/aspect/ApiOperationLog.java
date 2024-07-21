package com.jacob.weblog.framework.biz.operationlog.aspect;

import java.lang.annotation.*;

/**
 * @Author: Jacob
 * @Description: API 请求日志切面
 * @Date: 2024-07-19 20:51
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {
    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
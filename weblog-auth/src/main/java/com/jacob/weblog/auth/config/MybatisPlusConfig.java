package com.jacob.weblog.auth.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2024-07-19 21:12
 * @Version: 1.0
 */
@Configuration
@MapperScan("com.jacob.weblog.auth.domain.mapper")
public class MybatisPlusConfig {
//    /**
//     * 分页插件
//     * @return
//     */
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
//        return interceptor;
//    }
//
//    /**
//     * 自定义批量插入 SQL 注入器
//     */
//    @Bean
//    public InsertBatchSqlInjector insertBatchSqlInjector() {
//        return new InsertBatchSqlInjector();
//    }
}

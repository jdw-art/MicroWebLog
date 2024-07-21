package com.jacob.weblog.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: Jacob
 * @Description: weblog网关启动类
 * @Date: 2024-07-20 17:46
 * @Version: 1.0
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class WebLogGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebLogGatewayApplication.class, args);
    }
}

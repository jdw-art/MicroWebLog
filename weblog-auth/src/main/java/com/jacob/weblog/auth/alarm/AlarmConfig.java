package com.jacob.weblog.auth.alarm;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.jacob.weblog.auth.alarm.impl.MailAlarmHelper;
import com.jacob.weblog.auth.alarm.impl.SmsAlarmHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jacob
 * @Description: 告警配置类
 * @Date: 2024-07-20 18:06
 * @Version: 1.0
 */
@Configuration
@RefreshScope
public class AlarmConfig {

    @Value("${alarm.type}")
    private String alarmType;

    @Bean
    @RefreshScope
    public AlarmInterface alarmHelper() {
        // 根据配置文件中的告警类型，初始化选择不通的告警实现类
        if (StringUtils.equals("sms", alarmType)) {
            return new SmsAlarmHelper();
        } else if (StringUtils.equals("mail", alarmType)) {
            return new MailAlarmHelper();
        } else {
            throw new IllegalArgumentException("错误的告警信息...");
        }
    }

}



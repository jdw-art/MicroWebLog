package com.jacob.weblog.auth.alarm.impl;

import com.jacob.weblog.auth.alarm.AlarmInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Jacob
 * @Description: 邮件通知类
 * @Date: 2024-07-20 18:05
 * @Version: 1.0
 */
@Slf4j
public class MailAlarmHelper implements AlarmInterface {

    /**
     * 发送告警信息
     * @param message
     * @return
     */
    @Override
    public boolean send(String message) {
        log.info("==> 【邮件警告】：{}", message);

        // 业务逻辑...

        return false;
    }
}

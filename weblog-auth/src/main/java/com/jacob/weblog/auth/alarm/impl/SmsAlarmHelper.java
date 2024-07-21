package com.jacob.weblog.auth.alarm.impl;

import com.jacob.weblog.auth.alarm.AlarmInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Jacob
 * @Description: 短信告警类
 * @Date: 2024-07-20 18:05
 * @Version: 1.0
 */
@Slf4j
public class SmsAlarmHelper implements AlarmInterface {

    /**
     * 发送告警信息
     *
     * @param message
     * @return
     */
    @Override
    public boolean send(String message) {
        log.info("==> 【短信告警】：{}", message);

        // 业务逻辑...

        return true;
    }
}

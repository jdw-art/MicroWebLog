package com.jacob.weblog.auth.alarm;

/**
 * @Author: Jacob
 * @Description: 告警接口
 * @Date: 2024-07-20 18:04
 * @Version: 1.0
 */
public interface AlarmInterface {

    /**
     * 发送告警信息
     *
     * @param message
     * @return
     */
    boolean send(String message);
}

package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;

/**
 * @Author: Jacob
 * @Description: 博客设置信息service
 * @Date: 2024-07-21 22:02
 * @Version: 1.0
 */
public interface BlogSettingsService {
    /**
     * 获取博客设置信息
     * @return
     */
    Response findDetail();
}

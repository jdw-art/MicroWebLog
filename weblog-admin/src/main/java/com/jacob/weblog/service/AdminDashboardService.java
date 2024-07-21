package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;

/**
 * @Author: Jacob
 * @Description: 仪表盘业务service
 * @Date: 2024-07-21 20:30
 * @Version: 1.0
 */
public interface AdminDashboardService {

    /**
     * 获取仪表盘基础统计信息
     * @return
     */
    Response findDashboardStatistics();

    /**
     * 获取文章发布热点统计信息
     * @return
     */
    Response findDashboardPublishArticleStatistics();

    /**
     * 获取文章最近一周 PV 访问量统计信息
     * @return
     */
    Response findDashboardPVStatistics();
}
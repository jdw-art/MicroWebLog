package com.jacob.weblog.model.vo.dashboard;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 获取最近一周文章 PV 访问量出参VO
 * @Date: 2024-07-21 20:32
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询仪表盘文章 PV 访问量信息入参 VO")
public class FindDashboardPVStatisticsInfoRspVO {

    /**
     * 日期集合
     */
    private List<String> pvDates;

    /**
     * PV 浏览量集合
     */
    private List<Long> pvCounts;
}

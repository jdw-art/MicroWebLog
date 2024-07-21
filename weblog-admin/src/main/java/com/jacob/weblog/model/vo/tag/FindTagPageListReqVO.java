package com.jacob.weblog.model.vo.tag;

import com.jacob.weblog.framework.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: Jacob
 * @Description: 标签分页入参类
 * @Date: 2024-07-21 17:02
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询标签分页数据入参 VO")
public class FindTagPageListReqVO extends BasePageQuery {
    /**
     * 标签名称
     */
    private String name;

    /**
     * 创建的起始日期
     */
    private LocalDate startDate;

    /**
     * 创建的结束日期
     */
    private LocalDate endDate;
}

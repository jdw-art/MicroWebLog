package com.jacob.weblog.framework.common.model;

import lombok.Data;

/**
 * @Author: Jacob
 * @Description: 分页请求基础类
 * @Date: 2024-07-21 16:03
 * @Version: 1.0
 */
@Data
public class BasePageQuery {
    /**
     * 当前页码, 默认第一页
     */
    private Long current = 1L;
    /**
     * 每页展示的数据数量，默认每页展示 10 条数据
     */
    private Long size = 10L;
}

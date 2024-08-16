package com.jacob.weblog.model.vo.article;

import com.jacob.weblog.framework.common.model.BasePageQuery;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 获取热门文章分页数据请求参数
 * @Version: 1.0
 * @Date: 2024/8/16 17:42
 * @Version: 1.0
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Api(value = "获取热门文章分页数据请求参数")
public class FindHotArticlePageReqVO extends BasePageQuery {

    /**
     * 开始索引
     */
    private Long start;

    /**
     * 结束索引
     */
    private Long end;
}

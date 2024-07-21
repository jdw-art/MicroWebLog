package com.jacob.weblog.model.vo.article;

import com.jacob.weblog.framework.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: Jacob
 * @Description: 查询文章入参封装类
 * @Date: 2024-07-21 22:08
 * @Version: 1.0
 */
@Data
@Builder
@ApiModel(value = "首页查询文章分页 VO")
public class FindIndexArticlePageListReqVO extends BasePageQuery {
}

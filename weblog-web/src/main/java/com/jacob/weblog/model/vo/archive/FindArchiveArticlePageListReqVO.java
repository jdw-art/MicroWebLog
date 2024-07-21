package com.jacob.weblog.model.vo.archive;

import com.jacob.weblog.framework.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: Jacob
 * @Description: 文章归档入参封装类
 * @Date: 2024-07-21 22:18
 * @Version: 1.0
 */
@Data
@Builder
@ApiModel(value = "文章归档分页 VO")
public class FindArchiveArticlePageListReqVO extends BasePageQuery {
}

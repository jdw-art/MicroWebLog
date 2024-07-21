package com.jacob.weblog.model.vo.article;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 获取文章详情入参封装类
 * @Date: 2024-07-21 22:11
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询文章详情 VO")
public class FindArticleDetailReqVO {
    /**
     * 文章 ID
     */
    private Long articleId;
}

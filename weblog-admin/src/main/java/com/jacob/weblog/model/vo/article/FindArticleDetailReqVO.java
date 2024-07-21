package com.jacob.weblog.model.vo.article;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 获取文章详情入参封装类
 * @Date: 2024-07-21 19:33
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询文章详情入参 VO")
public class FindArticleDetailReqVO {
    /**
     * 文章 ID
     */
    @NotNull(message = "文章 ID 不能为空")
    private Long id;
}


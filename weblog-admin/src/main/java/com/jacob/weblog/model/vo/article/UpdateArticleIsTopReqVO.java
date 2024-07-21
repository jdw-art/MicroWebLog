package com.jacob.weblog.model.vo.article;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 文章置顶信息请求参数
 * @Date: 2024-07-21 19:34
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "更新文章置顶状态 VO")
public class UpdateArticleIsTopReqVO {
    @NotNull(message = "文章 ID 不能为空")
    private Long id;

    @NotNull(message = "文章置顶状态不能为空")
    private Boolean isTop;
}

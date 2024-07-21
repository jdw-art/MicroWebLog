package com.jacob.weblog.model.vo.article;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 删除文章入参封装类
 * @Date: 2024-07-21 19:32
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除文章 VO")
public class DeleteArticleReqVO {
    @NotNull(message = "文章 ID 不能为空")
    private Long id;
}

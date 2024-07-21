package com.jacob.weblog.model.vo.category;

import com.jacob.weblog.framework.common.model.BasePageQuery;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 文章分类入参封装类
 * @Date: 2024-07-21 21:27
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCategoryArticlePageListReqVO extends BasePageQuery {

    /**
     * 分类 ID
     */
    @NotNull(message = "分类 ID 不能为空")
    private Long id;
}

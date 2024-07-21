package com.jacob.weblog.model.vo.tag;

import com.jacob.weblog.framework.common.model.BasePageQuery;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 标签下文章分页请求类
 * @Date: 2024-07-21 21:51
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindTagArticlePageListReqVO extends BasePageQuery {
    /**
     * 标签 ID
     */
    @NotNull(message = "标签 ID 不能为空")
    private Long id;
}

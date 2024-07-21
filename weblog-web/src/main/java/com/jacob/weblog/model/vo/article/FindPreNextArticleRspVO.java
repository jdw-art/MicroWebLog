package com.jacob.weblog.model.vo.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 上下篇文章出参封装类
 * @Date: 2024-07-21 22:12
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindPreNextArticleRspVO {
    /**
     * 文章 ID
     */
    private Long articleId;

    /**
     * 文章标题
     */
    private String articleTitle;
}

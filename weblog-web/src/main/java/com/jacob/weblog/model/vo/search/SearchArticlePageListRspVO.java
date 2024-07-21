package com.jacob.weblog.model.vo.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 文章搜索出参 VO
 * @Date: 2024-07-21 22:33
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchArticlePageListRspVO {
    /**
     * 文章 ID
     */
    private Long id;
    /**
     * 封面
     */
    private String cover;
    /**
     * 标题
     */
    private String title;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 发布日期
     */
    private String createDate;
}

package com.jacob.weblog.model.vo.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: Jacob
 * @Description: 分页获取文章出参封装类
 * @Date: 2024-07-21 20:09
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindArticlePageListRspVO {
    /**
     * 文章 ID
     */
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章封面
     */
    private String cover;

    /**
     * 发布时间
     */
    private LocalDateTime createTime;

    /**
     * 是否置顶
     */
    private Boolean isTop;
}

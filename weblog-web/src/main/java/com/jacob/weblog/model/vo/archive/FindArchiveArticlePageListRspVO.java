package com.jacob.weblog.model.vo.archive;

import com.jacob.weblog.model.vo.article.FindArchiveArticleRspVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;
import java.util.List;

/**
 * @Author: Jacob
 * @Description: 文章归档分页出参封装类
 * @Date: 2024-07-21 22:18
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindArchiveArticlePageListRspVO {
    /**
     * 归档的月份
     */
    private YearMonth month;

    private List<FindArchiveArticleRspVO> articles;
}

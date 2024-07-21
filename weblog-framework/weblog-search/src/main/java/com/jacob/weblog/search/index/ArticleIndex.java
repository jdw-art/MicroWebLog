package com.jacob.weblog.search.index;

/**
 * @Author: Jacob
 * @Description: ArticleIndex 索引接口
 * @Date: 2024-07-21 19:58
 * @Version: 1.0
 */
public interface ArticleIndex {
    /**
     * 索引名称
     */
    String NAME = "article";

    // --------------------- 文档字段 ---------------------
    String COLUMN_ID = "id";

    String COLUMN_TITLE = "title";

    String COLUMN_COVER = "cover";

    String COLUMN_SUMMARY = "summary";

    String COLUMN_CONTENT = "content";

    String COLUMN_CREATE_TIME = "createTime";
}

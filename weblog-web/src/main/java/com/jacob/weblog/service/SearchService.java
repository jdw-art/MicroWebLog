package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.search.SearchArticlePageListReqVO;

/**
 * @Author: Jacob
 * @Description: 关键词分页搜索service
 * @Date: 2024-07-21 22:32
 * @Version: 1.0
 */
public interface SearchService {
    /**
     * 关键词分页搜索
     * @param searchArticlePageListReqVO
     * @return
     */
    Response searchArticlePageList(SearchArticlePageListReqVO searchArticlePageListReqVO);
}


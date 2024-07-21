package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.article.FindArticleDetailReqVO;
import com.jacob.weblog.model.vo.article.FindIndexArticlePageListReqVO;

/**
 * @Author: Jacob
 * @Description: 前台文章数据service
 * @Date: 2024-07-21 22:08
 * @Version: 1.0
 */
public interface ArticleService {
    /**
     * 获取首页文章分页数据
     * @param findIndexArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindIndexArticlePageListReqVO findIndexArticlePageListReqVO);

    /**
     * 获取文章详情
     * @param findArticleDetailReqVO
     * @return
     */
    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);
}

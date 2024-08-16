package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.article.FindArticleDetailReqVO;
import com.jacob.weblog.model.vo.article.FindHotArticlePageReqVO;

/**
 * @Author: Jacob
 * @Description: 热门文章排行接口
 * @Date: 2024/8/16 15:31
 * @Version: 1.0
 */
public interface HotArticleService {

    /**
     * 查看文章数据
     * @param findArticleDetailReqVO
     * @return
     */
    Response<?> getArticle(FindArticleDetailReqVO findArticleDetailReqVO);


    /**
     * 获取文章小时排行榜
     * @param findHotArticlePageReqVO
     * @return
     */
    Response rankHourArticle(FindHotArticlePageReqVO findHotArticlePageReqVO);

    /**
     * 获取文章日排行榜
     * @param findHotArticlePageReqVO
     * @return
     */
    Response rankDayArticle(FindHotArticlePageReqVO findHotArticlePageReqVO);

    /**
     * 获取文章总排行榜
     * @param findHotArticlePageReqVO
     * @return
     */
    Response rankTotalArticle(FindHotArticlePageReqVO findHotArticlePageReqVO);

}

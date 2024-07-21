package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.article.*;

/**
 * @Author: Jacob
 * @Description: 文章管理service接口
 * @Date: 2024-07-21 19:31
 * @Version: 1.0
 */
public interface AdminArticleService {

    /**
     * 发布文章
     * @param publishArticleReqVO
     * @return
     */
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);

    /**
     * 删除文章
     * @param deleteArticleReqVO
     * @return
     */
    Response deleteArticle(DeleteArticleReqVO deleteArticleReqVO);

    /**
     * 查询文章分页数据
     * @param findArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindArticlePageListReqVO findArticlePageListReqVO);

    /**
     * 查询文章详情
     * @param findArticleDetailReqVO
     * @return
     */
    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);

    /**
     * 更新文章
     * @param updateArticleReqVO
     * @return
     */
    Response updateArticle(UpdateArticleReqVO updateArticleReqVO);

    /**
     * 更新文章是否置顶
     * @param updateArticleIsTopReqVO
     * @return
     */
    Response updateArticleIsTop(UpdateArticleIsTopReqVO updateArticleIsTopReqVO);
}

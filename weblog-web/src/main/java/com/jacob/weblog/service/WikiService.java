package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.wiki.FindWikiArticlePreNextReqVO;
import com.jacob.weblog.model.vo.wiki.FindWikiCatalogListReqVO;

/**
 * @Author: Jacob
 * @Description: 知识库业务接口
 * @Date: 2024-07-21 22:24
 * @Version: 1.0
 */
public interface WikiService {

    /**
     * 获取知识库
     * @return
     */
    Response findWikiList();

    /**
     * 获取知识库目录
     * @param findWikiCatalogListReqVO
     * @return
     */
    Response findWikiCatalogList(FindWikiCatalogListReqVO findWikiCatalogListReqVO);

    /**
     * 获取上下页
     * @param findWikiArticlePreNextReqVO
     * @return
     */
    Response findArticlePreNext(FindWikiArticlePreNextReqVO findWikiArticlePreNextReqVO);
}

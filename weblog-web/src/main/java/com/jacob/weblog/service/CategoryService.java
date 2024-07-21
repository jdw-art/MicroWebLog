package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.category.FindCategoryArticlePageListReqVO;
import com.jacob.weblog.model.vo.category.FindCategoryListReqVO;

/**
 * @Author: Jacob
 * @Description: 文章分类service
 * @Date: 2024-07-21 21:26
 * @Version: 1.0
 */
public interface CategoryService {
    /**
     * 获取分类列表
     * @return
     */
    Response findCategoryList(FindCategoryListReqVO findCategoryListReqVO);

    /**
     * 获取分类下文章分页数据
     * @param findCategoryArticlePageListReqVO
     * @return
     */
    Response findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO);
}


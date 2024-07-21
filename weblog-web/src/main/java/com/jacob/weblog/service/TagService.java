package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.tag.FindTagArticlePageListReqVO;

/**
 * @Author: Jacob
 * @Description: 文章标签service
 * @Date: 2024-07-21 21:51
 * @Version: 1.0
 */
public interface TagService {

    /**
     * 获取标签列表
     * @return
     */
    Response findTagList();

    /**
     * 获取标签下文章分页列表
     * @param findTagArticlePageListReqVO
     * @return
     */
    Response findTagPageList(FindTagArticlePageListReqVO findTagArticlePageListReqVO);
}

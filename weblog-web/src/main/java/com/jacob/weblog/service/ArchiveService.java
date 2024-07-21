package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.archive.FindArchiveArticlePageListReqVO;

/**
 * @Author: Jacob
 * @Description: 文章归档业务接口
 * @Date: 2024-07-21 22:17
 * @Version: 1.0
 */
public interface ArchiveService {
    /**
     * 获取文章归档分页数据
     * @param findArchiveArticlePageListReqVO
     * @return
     */
    Response findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO);
}

package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.PageResponse;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.tag.AddTagReqVO;
import com.jacob.weblog.model.vo.tag.DeleteTagReqVO;
import com.jacob.weblog.model.vo.tag.FindTagPageListReqVO;
import com.jacob.weblog.model.vo.tag.SearchTagsReqVO;

/**
 * @Author: Jacob
 * @Description: 文章标签管理接口类
 * @Date: 2024-07-21 17:01
 * @Version: 1.0
 */
public interface AdminTagService {
    /**
     * 添加标签集合
     * @param addTagReqVO
     * @return
     */
    Response addTags(AddTagReqVO addTagReqVO);

    /**
     * 查询标签分页
     * @param findTagPageListReqVO
     * @return
     */
    PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO);

    /**
     * 删除标签
     * @param deleteTagReqVO
     * @return
     */
    Response deleteTag(DeleteTagReqVO deleteTagReqVO);

    /**
     * 根据标签关键词模糊查询
     * @param searchTagsReqVO
     * @return
     */
    Response searchTags(SearchTagsReqVO searchTagsReqVO);

    /**
     * 查询标签 Select 列表数据
     * @return
     */
    Response findTagSelectList();
}

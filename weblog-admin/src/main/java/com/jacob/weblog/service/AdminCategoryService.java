package com.jacob.weblog.service;

import com.jacob.weblog.framework.common.response.PageResponse;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.FindCategoryPageListReqVO;
import com.jacob.weblog.model.vo.category.AddCategoryReqVO;
import com.jacob.weblog.model.vo.category.DeleteCategoryReqVO;

/**
 * @Author: Jacob
 * @Description: 文章分类管理接口类
 * @Date: 2024-07-21 15:59
 * @Version: 1.0
 */
public interface AdminCategoryService {
    /**
     * 添加分类
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);

    /**
     * 分类分页数据查询
     * @param findCategoryPageListReqVO
     * @return
     */
    PageResponse findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO);

    // 省略...

    /**
     * 删除分类
     * @param deleteCategoryReqVO
     * @return
     */
    Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);

    /**
     * 获取文章分类的 Select 列表数据
     * @return
     */
    Response findCategorySelectList();
}

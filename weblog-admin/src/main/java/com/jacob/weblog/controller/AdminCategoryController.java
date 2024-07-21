package com.jacob.weblog.controller;

import com.jacob.weblog.framework.biz.operationlog.aspect.ApiOperationLog;
import com.jacob.weblog.framework.common.response.PageResponse;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.FindCategoryPageListReqVO;
import com.jacob.weblog.model.vo.category.AddCategoryReqVO;
import com.jacob.weblog.model.vo.category.DeleteCategoryReqVO;
import com.jacob.weblog.service.AdminCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jacob
 * @Description: 文章分类管理
 * @Date: 2024-07-21 16:09
 * @Version: 1.0
 */
@RestController
@Api(tags = "Admin 分类模块")
public class AdminCategoryController {
    @Autowired
    private AdminCategoryService categoryService;

    @PostMapping("/category/add")
    @ApiOperation(value = "添加分类")
    @ApiOperationLog(description = "添加分类")
    public Response addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO) {
        return categoryService.addCategory(addCategoryReqVO);
    }

    @PostMapping("/category/list")
    @ApiOperation(value = "分类分页数据获取")
    @ApiOperationLog(description = "分类分页数据获取")
    public PageResponse findCategoryList(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO) {
        return categoryService.findCategoryList(findCategoryPageListReqVO);
    }

    @PostMapping("/category/delete")
    @ApiOperation(value = "删除分类")
    @ApiOperationLog(description = "删除分类")
    public Response deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO) {
        return categoryService.deleteCategory(deleteCategoryReqVO);
    }

    @PostMapping("/category/select/list")
    @ApiOperation(value = "分类 Select 下拉列表数据获取")
    @ApiOperationLog(description = "分类 Select 下拉列表数据获取")
    public Response findCategorySelectList() {
        return categoryService.findCategorySelectList();
    }
}


package com.jacob.weblog.controller;

import com.jacob.weblog.framework.biz.operationlog.aspect.ApiOperationLog;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.archive.FindArchiveArticlePageListReqVO;
import com.jacob.weblog.service.ArchiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jacob
 * @Description: 文章归档业务Controller
 * @Date: 2024-07-21 22:20
 * @Version: 1.0
 */
@RestController
@Api(tags = "文章归档")
public class ArchiveController {
    @Autowired
    private ArchiveService archiveService;

    @PostMapping("/archive/list")
    @ApiOperation(value = "获取文章归档分页数据")
    @ApiOperationLog(description = "获取文章归档分页数据")
    public Response findArchivePageList(@RequestBody FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO) {
        return archiveService.findArchivePageList(findArchiveArticlePageListReqVO);
    }
}

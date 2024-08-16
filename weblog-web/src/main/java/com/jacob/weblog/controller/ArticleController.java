package com.jacob.weblog.controller;

import com.jacob.weblog.framework.biz.operationlog.aspect.ApiOperationLog;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.article.FindArticleDetailReqVO;
import com.jacob.weblog.model.vo.article.FindHotArticlePageReqVO;
import com.jacob.weblog.model.vo.article.FindIndexArticlePageListReqVO;
import com.jacob.weblog.service.ArticleService;
import com.jacob.weblog.service.HotArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Jacob
 * @Description: 前台文章数据Controller
 * @Date: 2024-07-21 22:13
 * @Version: 1.0
 */
@RestController
@RequestMapping("/web/article")
@Api(tags = "文章")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Resource
    private HotArticleService hotArticleService;

    @PostMapping("/list")
    @ApiOperation(value = "获取首页文章分页数据")
    @ApiOperationLog(description = "获取首页文章分页数据")
    public Response findArticlePageList(@RequestBody FindIndexArticlePageListReqVO findIndexArticlePageListReqVO) {
        return articleService.findArticlePageList(findIndexArticlePageListReqVO);
    }


    @PostMapping("/detail")
    @ApiOperation(value = "获取文章详情")
    @ApiOperationLog(description = "获取文章详情")
    public Response findArticleDetail(@RequestBody FindArticleDetailReqVO findArticleDetailReqVO) {
        return articleService.findArticleDetail(findArticleDetailReqVO);
    }

    @PostMapping("/hot")
    @ApiOperationLog(description = "获取文章数据并更新热榜")
    public Response findArticleAndUpdateHot(@RequestBody FindArticleDetailReqVO findArticleDetailReqVO) {
        return hotArticleService.getArticle(findArticleDetailReqVO);
    }

    @RequestMapping("/hot/hour")
    @ApiOperationLog(description = "获取小时文章热榜数据")
    public Response findHourHotArticle(@RequestBody FindHotArticlePageReqVO findHotArticlePageReqVO) {
        return hotArticleService.rankHourArticle(findHotArticlePageReqVO);
    }

    @RequestMapping("/hot/day")
    @ApiOperationLog(description = "获取天文章热榜数据")
    public Response findDayHotArticle(@RequestBody FindHotArticlePageReqVO findHotArticlePageReqVO) {
        return hotArticleService.rankDayArticle(findHotArticlePageReqVO);
    }

    @RequestMapping("/hot/total")
    @ApiOperationLog(description = "获取总文章热榜数据")
    public Response findTotalHotArticle(@RequestBody FindHotArticlePageReqVO findHotArticlePageReqVO) {
        return hotArticleService.rankTotalArticle(findHotArticlePageReqVO);
    }

}

package com.jacob.weblog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.jacob.weblog.constant.RedisConstant;
import com.jacob.weblog.convert.ArticleConvert;
import com.jacob.weblog.event.ReadArticleEvent;
import com.jacob.weblog.framework.common.domain.dataobject.*;
import com.jacob.weblog.framework.common.domain.mapper.*;
import com.jacob.weblog.framework.common.enums.ResponseCodeEnum;
import com.jacob.weblog.framework.common.exception.BizException;
import com.jacob.weblog.framework.common.response.PageResponse;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.article.FindArticleDetailReqVO;
import com.jacob.weblog.model.vo.article.FindHotArticlePageReqVO;
import com.jacob.weblog.model.vo.article.FindIndexArticlePageListRspVO;
import com.jacob.weblog.model.vo.category.FindCategoryListRspVO;
import com.jacob.weblog.model.vo.tag.FindTagListRspVO;
import com.jacob.weblog.service.HotArticleService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Jacob
 * @Description: 热门文章排行业务
 * @Date: 2024/8/16 15:37
 * @Version: 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class HotArticleServiceImpl implements HotArticleService {

    private final RedisTemplate<String, Object> redisTemplate;
    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Resource
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleCategoryRelMapper articleCategoryRelMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;

    @Override
    public Response<?> getArticle(FindArticleDetailReqVO findArticleDetailReqVO) {
        Long articleId = findArticleDetailReqVO.getArticleId();
        ArticleDO articleDO = articleMapper.selectById(articleId);
        if (articleDO == null) {
            throw new BizException(ResponseCodeEnum.ARTICLE_NOT_FOUND);
        } else {

            // 增加总排行榜
            String sortKey = RedisConstant.getSortKey();
            BoundZSetOperations<String, Object> zSetSort  = redisTemplate.boundZSetOps(sortKey);
            if (zSetSort.size() == null || zSetSort.size() == 0) {
                List<ArticleDO> articleDOList = articleMapper.selectAllArticleIdAndReadNum();
                for (ArticleDO article : articleDOList) {
                    zSetSort.add(article.getId(), article.getReadNum());
                }
            }
            zSetSort.incrementScore(articleId, 1.0);

            // 增加小时排行榜
            String hourSortKey = RedisConstant.getSortHourKey();
            BoundZSetOperations<String, Object> zSetHour = redisTemplate.boundZSetOps(hourSortKey);
            zSetHour.incrementScore(articleId, 1.0);

            // 增加当天排行榜
            String daySortKey = RedisConstant.getSortDayKey();
            BoundZSetOperations<String, Object> zSetDay = redisTemplate.boundZSetOps(daySortKey);
            zSetDay.incrementScore(articleId, 1.0);

            // 发布文章阅读事件
            eventPublisher.publishEvent(new ReadArticleEvent(this, articleId));

            return Response.success(articleDO);

        }
    }

    /**
     * 获取小时排行
     * @param findHotArticlePageReqVO
     * @return
     */
    @Override
    public Response rankHourArticle(FindHotArticlePageReqVO findHotArticlePageReqVO) {
        return rank(findHotArticlePageReqVO, RedisConstant.getSortHourKey());
    }

    /**
     * 获取日排行
     * @param findHotArticlePageReqVO
     * @return
     */
    @Override
    public Response rankDayArticle(FindHotArticlePageReqVO findHotArticlePageReqVO) {
        return rank(findHotArticlePageReqVO, RedisConstant.getSortDayKey());
    }

    /**
     * 获取总排行
     * @param findHotArticlePageReqVO
     * @return
     */
    @Override
    public Response rankTotalArticle(FindHotArticlePageReqVO findHotArticlePageReqVO) {
        return rank(findHotArticlePageReqVO, RedisConstant.getSortKey());
    }

    public Response rank(FindHotArticlePageReqVO findHotArticlePageReqVO, String sortKey) {
        Long current = findHotArticlePageReqVO.getCurrent();
        Long size = findHotArticlePageReqVO.getSize();
        Long start = findHotArticlePageReqVO.getStart();
        Long end = findHotArticlePageReqVO.getEnd();

        BoundZSetOperations<String, Object> operations = redisTemplate.boundZSetOps(sortKey);

        Set<Object> rankObjects = operations.reverseRange(start, end);

        if (CollectionUtils.isEmpty(rankObjects)) {
            return Response.success();
        }

        List<Long> hotArticleIds = rankObjects.stream().map(obj -> Long.parseLong(obj.toString())).toList();

        // 第一步：分页查询文章主体记录
        Page<ArticleDO> articleDOPage = articleMapper.selectPageListByArticleIds(current, size, hotArticleIds);

        // 返回的分页数据
        List<ArticleDO> articleDOS = articleDOPage.getRecords();

        List<FindIndexArticlePageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(articleDOS)) {
            // 文章 DO 转 VO
            vos = articleDOS.stream()
                    .map(articleDO -> {
                        FindIndexArticlePageListRspVO vo = ArticleConvert.INSTANCE.convertDO2VO(articleDO);
                        vo.setIsTop(articleDO.getWeight() > 0); // 是否置顶
                        return vo;
                    })
                    .collect(Collectors.toList());

            // 拿到所有文章的 ID 集合
            List<Long> articleIds = articleDOS.stream().map(ArticleDO::getId).collect(Collectors.toList());

            // 第二步：设置文章所属分类
            // 查询所有分类
            List<CategoryDO> categoryDOS = categoryMapper.selectList(Wrappers.emptyWrapper());
            // 转 Map, 方便后续根据分类 ID 拿到对应的分类名称
            Map<Long, String> categoryIdNameMap = categoryDOS.stream().collect(Collectors.toMap(CategoryDO::getId, CategoryDO::getName));

            // 根据文章 ID 批量查询所有关联记录
            List<ArticleCategoryRelDO> articleCategoryRelDOS = articleCategoryRelMapper.selectByArticleIds(articleIds);

            vos.forEach(vo -> {
                Long currArticleId = vo.getId();
                // 过滤出当前文章对应的关联数据
                Optional<ArticleCategoryRelDO> optional = articleCategoryRelDOS.stream().filter(rel -> Objects.equals(rel.getArticleId(), currArticleId)).findAny();

                // 若不为空
                if (optional.isPresent()) {
                    ArticleCategoryRelDO articleCategoryRelDO = optional.get();
                    Long categoryId = articleCategoryRelDO.getCategoryId();
                    // 通过分类 ID 从 map 中拿到对应的分类名称
                    String categoryName = categoryIdNameMap.get(categoryId);

                    FindCategoryListRspVO findCategoryListRspVO = FindCategoryListRspVO.builder()
                            .id(categoryId)
                            .name(categoryName)
                            .build();
                    // 设置到当前 vo 类中
                    vo.setCategory(findCategoryListRspVO);
                }
            });

            // 第三步：设置文章标签
            // 查询所有标签
            List<TagDO> tagDOS = tagMapper.selectList(Wrappers.emptyWrapper());
            // 转 Map, 方便后续根据标签 ID 拿到对应的标签名称
            Map<Long, String> mapIdNameMap = tagDOS.stream().collect(Collectors.toMap(TagDO::getId, TagDO::getName));

            // 拿到所有文章的标签关联记录
            List<ArticleTagRelDO> articleTagRelDOS = articleTagRelMapper.selectByArticleIds(articleIds);
            vos.forEach(vo -> {
                Long currArticleId = vo.getId();
                // 过滤出当前文章的标签关联记录
                List<ArticleTagRelDO> articleTagRelDOList = articleTagRelDOS.stream().filter(rel -> Objects.equals(rel.getArticleId(), currArticleId)).collect(Collectors.toList());

                List<FindTagListRspVO> findTagListRspVOS = Lists.newArrayList();
                // 将关联记录 DO 转 VO, 并设置对应的标签名称
                articleTagRelDOList.forEach(articleTagRelDO -> {
                    Long tagId = articleTagRelDO.getTagId();
                    String tagName = mapIdNameMap.get(tagId);

                    FindTagListRspVO findTagListRspVO = FindTagListRspVO.builder()
                            .id(tagId)
                            .name(tagName)
                            .build();
                    findTagListRspVOS.add(findTagListRspVO);
                });
                // 设置转换后的标签数据
                vo.setTags(findTagListRspVOS);
            });
        }

        return PageResponse.success(articleDOPage, vos);
    }
}

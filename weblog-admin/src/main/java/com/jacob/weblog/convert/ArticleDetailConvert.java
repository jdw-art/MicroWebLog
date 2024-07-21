package com.jacob.weblog.convert;

import com.jacob.weblog.framework.common.domain.dataobject.ArticleDO;
import com.jacob.weblog.model.vo.article.FindArticleDetailRspVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: Jacob
 * @Description: Mapstruct 转换接口
 * @Date: 2024-07-21 20:10
 * @Version: 1.0
 */
@Mapper
public interface ArticleDetailConvert {
    /**
     * 初始化 convert 实例
     */
    ArticleDetailConvert INSTANCE = Mappers.getMapper(ArticleDetailConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindArticleDetailRspVO convertDO2VO(ArticleDO bean);
}

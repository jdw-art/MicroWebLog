package com.jacob.weblog.convert;

import com.jacob.weblog.framework.common.domain.dataobject.WikiDO;
import com.jacob.weblog.model.vo.wiki.FindWikiPageListRspVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Author: Jacob
 * @Description: 知识库convert 转换接口
 * @Date: 2024-07-21 21:00
 * @Version: 1.0
 */
@Mapper
public interface WikiConvert {
    /**
     * 初始化 convert 实例
     */
    WikiConvert INSTANCE = Mappers.getMapper(WikiConvert.class);

    /**
     * WikiDO -> FindWikiPageListRspVO
     * @param bean
     * @return
     */
    @Mapping(target = "isTop", expression = "java(bean.getWeight() > 0)")
    FindWikiPageListRspVO convertDO2VO(WikiDO bean);
}

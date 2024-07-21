package com.jacob.weblog.convert;

import com.jacob.weblog.framework.common.domain.dataobject.BlogSettingsDO;
import com.jacob.weblog.model.vo.blogsettings.FindBlogSettingsDetailRspVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: Jacob
 * @Description: convert 转换接口
 * @Date: 2024-07-21 22:04
 * @Version: 1.0
 */
@Mapper
public interface BlogSettingsConvert {
    /**
     * 初始化 convert 实例
     */
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindBlogSettingsDetailRspVO convertDO2VO(BlogSettingsDO bean);
}

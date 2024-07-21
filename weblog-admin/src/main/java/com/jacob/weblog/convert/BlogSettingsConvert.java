package com.jacob.weblog.convert;

import com.jacob.weblog.framework.common.domain.dataobject.BlogSettingsDO;
import com.jacob.weblog.model.vo.blogsettings.FindBlogSettingsRspVO;
import com.jacob.weblog.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author: Jacob
 * @Description: 转换接口
 * @Date: 2024-07-21 19:09
 * @Version: 1.0
 */
@Mapper
public interface BlogSettingsConvert {
    /**
     * 初始化 convert 实例
     */
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    /**
     * 将 VO 转化为 DO
     * @param bean
     * @return
     */
    BlogSettingsDO convertVO2DO(UpdateBlogSettingsReqVO bean);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindBlogSettingsRspVO convertDO2VO(BlogSettingsDO bean);
}

package com.jacob.weblog.service.impl;

import com.jacob.weblog.convert.BlogSettingsConvert;
import com.jacob.weblog.framework.biz.context.holder.LoginUserContextHolder;
import com.jacob.weblog.framework.common.domain.dataobject.BlogSettingsDO;
import com.jacob.weblog.framework.common.domain.mapper.BlogSettingsMapper;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.blogsettings.FindBlogSettingsDetailRspVO;
import com.jacob.weblog.service.BlogSettingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Jacob
 * @Description: 博客设置信息service实现类
 * @Date: 2024-07-21 22:03
 * @Version: 1.0
 */
@Service
@Slf4j
public class BlogSettingsServiceImpl implements BlogSettingsService {

    @Autowired
    private BlogSettingsMapper blogSettingsMapper;

    /**
     * 获取博客设置信息
     *
     * @return
     */
    @Override
    public Response findDetail() {
        // 查询博客设置信息（约定的 ID 为 1）
        Long userId = LoginUserContextHolder.getUserId();
        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectById(userId);
        // DO 转 VO
        FindBlogSettingsDetailRspVO vo = BlogSettingsConvert.INSTANCE.convertDO2VO(blogSettingsDO);

        return Response.success(vo);
    }
}

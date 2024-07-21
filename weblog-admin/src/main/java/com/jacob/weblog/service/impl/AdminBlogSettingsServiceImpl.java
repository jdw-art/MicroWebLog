package com.jacob.weblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jacob.weblog.convert.BlogSettingsConvert;
import com.jacob.weblog.framework.biz.context.holder.LoginUserContextHolder;
import com.jacob.weblog.framework.common.domain.dataobject.BlogSettingsDO;
import com.jacob.weblog.framework.common.domain.mapper.BlogSettingsMapper;
import com.jacob.weblog.framework.common.response.Response;
import com.jacob.weblog.model.vo.blogsettings.FindBlogSettingsRspVO;
import com.jacob.weblog.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import com.jacob.weblog.service.AdminBlogSettingsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Jacob
 * @Description: 博客设置管理service实现类
 * @Date: 2024-07-21 18:57
 * @Version: 1.0
 */
@Service
@Slf4j
public class AdminBlogSettingsServiceImpl extends ServiceImpl<BlogSettingsMapper, BlogSettingsDO> implements AdminBlogSettingsService {

    @Resource
    private BlogSettingsMapper blogSettingsMapper;

    @Override
    public Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO) {

        Long userId = LoginUserContextHolder.getUserId();
        // VO 转 DO
        BlogSettingsDO blogSettingsDO = BlogSettingsConvert.INSTANCE.convertVO2DO(updateBlogSettingsReqVO);
        blogSettingsDO.setId(userId);

        // 保存或更新（当数据库中存在 ID 为 1 的记录时，则执行更新操作，否则执行插入操作）
        saveOrUpdate(blogSettingsDO);
        return Response.success();
    }

    /**
     * 获取博客设置详情
     *
     * @return
     */
    @Override
    public Response findDetail() {
        // 查询 ID 为 1 的记录
        Long userId = LoginUserContextHolder.getUserId();
        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectById(userId);

        // DO 转 VO
        FindBlogSettingsRspVO vo = BlogSettingsConvert.INSTANCE.convertDO2VO(blogSettingsDO);

        return Response.success(vo);
    }
}

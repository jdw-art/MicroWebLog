package com.jacob.weblog.framework.common.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 批量插入标签接口
 * @Date: 2024-07-21 15:52
 * @Version: 1.0
 */
public interface InsertBatchMapper<T> extends BaseMapper<T> {
    // 批量插入
    int insertBatchSomeColumn(@Param("list") List<T> batchList);
}

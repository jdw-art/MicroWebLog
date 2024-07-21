package com.jacob.weblog.model.vo.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 分类列表入参实体类
 * @Date: 2024-07-21 21:27
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCategoryListReqVO {
    /**
     * 展示数量
     */
    private Long size;
}

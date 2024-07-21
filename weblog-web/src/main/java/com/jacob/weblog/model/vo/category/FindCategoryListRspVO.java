package com.jacob.weblog.model.vo.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 查询文章分类封装类
 * @Date: 2024-07-21 21:29
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCategoryListRspVO {
    private Long id;
    private String name;
    private Integer articlesTotal;
}

package com.jacob.weblog.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Jacob
 * @Description: 知识库目录枚举类
 * @Date: 2024-07-21 15:54
 * @Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum WikiCatalogLevelEnum {
    // 一级目录
    ONE(1),
    // 二级目录
    TWO(2);

    private Integer value;
}

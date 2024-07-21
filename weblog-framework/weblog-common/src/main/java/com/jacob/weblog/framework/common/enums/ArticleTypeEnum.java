package com.jacob.weblog.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: Jacob
 * @Description: 知识库相关枚举类
 * @Date: 2024-07-21 15:54
 * @Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum ArticleTypeEnum {
    NORMAL(1, "普通"),
    WIKI(2, "收录于知识库");

    private Integer value;
    private String description;
}

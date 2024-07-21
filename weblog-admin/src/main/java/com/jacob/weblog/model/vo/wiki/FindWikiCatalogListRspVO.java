package com.jacob.weblog.model.vo.wiki;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 查询知识库目录数据出参 VO
 * @Date: 2024-07-21 20:55
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindWikiCatalogListRspVO {

    /**
     * 知识库 ID
     */
    private Long id;

    private Long articleId;

    private String title;

    private Integer sort;

    private Integer level;

    /**
     * 是否处于编辑状态（用于前端是否显示编辑输入框）
     */
    private Boolean editing;

    /**
     * 二级目录
     */
    private List<FindWikiCatalogListRspVO> children;
}

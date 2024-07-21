package com.jacob.weblog.model.vo.wiki;

import io.swagger.annotations.ApiModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 更新知识库目录数据入参 VO
 * @Date: 2024-07-21 20:56
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "更新知识库目录数据入参 VO")
public class UpdateWikiCatalogReqVO {

    /**
     * 知识库 ID
     */
    @NotNull(message = "知识库 ID 不能为空")
    private Long id;

    /**
     * 目录
     */
    @Valid
    private List<UpdateWikiCatalogItemReqVO> catalogs;


}
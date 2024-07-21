package com.jacob.weblog.model.vo.wiki;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 更新知识库置顶入参类
 * @Date: 2024-07-21 20:57
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "更新知识库置顶状态 VO")
public class UpdateWikiIsTopReqVO {

    @NotNull(message = "知识库 ID 不能为空")
    private Long id;

    @NotNull(message = "知识库置顶状态不能为空")
    private Boolean isTop;

}

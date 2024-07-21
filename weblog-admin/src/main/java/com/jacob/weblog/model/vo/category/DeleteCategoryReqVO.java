package com.jacob.weblog.model.vo.category;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 删除分类请求包装类
 * @Date: 2024-07-21 16:04
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除分类 VO")
public class DeleteCategoryReqVO {
    @NotNull(message = "分类 ID 不能为空")
    private Long id;
}

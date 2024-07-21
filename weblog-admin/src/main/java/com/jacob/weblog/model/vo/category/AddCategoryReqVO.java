package com.jacob.weblog.model.vo.category;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @Author: Jacob
 * @Description: 文章分类参数实体类
 * @Date: 2024-07-21 15:57
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "添加分类 VO")
public class AddCategoryReqVO {
    @NotBlank(message = "分类名称不能为空")
    @Length(min = 1, max = 20, message = "分类名称字数限制 1 ~ 10 之间")
    private String name;
}

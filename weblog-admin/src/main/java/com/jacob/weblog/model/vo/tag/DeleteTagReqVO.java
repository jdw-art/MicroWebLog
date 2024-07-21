package com.jacob.weblog.model.vo.tag;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 删除标签参数类
 * @Date: 2024-07-21 17:02
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "删除标签 VO")
public class DeleteTagReqVO {
    @NotNull(message = "标签 ID 不能为空")
    private Long id;
}

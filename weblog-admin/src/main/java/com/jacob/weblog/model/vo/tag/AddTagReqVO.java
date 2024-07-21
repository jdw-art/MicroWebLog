package com.jacob.weblog.model.vo.tag;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 标签新增参数类
 * @Date: 2024-07-21 17:01
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "添加标签 VO")
public class AddTagReqVO {

    @NotEmpty(message = "标签集合不能为空")
    private List<String> tags;

}

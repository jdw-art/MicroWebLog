package com.jacob.weblog.model.vo.article;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 文章发布请求封装类
 * @Date: 2024-07-21 19:31
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "发布文章 VO")
public class PublishArticleReqVO {
    @NotBlank(message = "文章标题不能为空")
    @Length(min = 1, max = 40, message = "文章标题字数需大于 1 小于 40")
    private String title;

    @NotBlank(message = "文章内容不能为空")
    private String content;

    @NotBlank(message = "文章封面不能为空")
    private String cover;

    private String summary;

    @NotNull(message = "文章分类不能为空")
    private Long categoryId;

    @NotEmpty(message = "文章标签不能为空")
    private List<String> tags;
}

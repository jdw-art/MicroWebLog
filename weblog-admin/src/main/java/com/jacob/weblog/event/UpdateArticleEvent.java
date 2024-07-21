package com.jacob.weblog.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: Jacob
 * @Description: 文章更新事件
 * @Date: 2024-07-21 19:38
 * @Version: 1.0
 */
@Getter
public class UpdateArticleEvent extends ApplicationEvent {
    /**
     * 文章 ID
     */
    private Long articleId;

    public UpdateArticleEvent(Object source, Long articleId) {
        super(source);
        this.articleId = articleId;
    }
}

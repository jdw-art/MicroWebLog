package com.jacob.weblog.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: Jacob
 * @Description: 文章被阅读事件类
 * @Date: 2024-07-21 19:38
 * @Version: 1.0
 */
@Getter
public class ReadArticleEvent extends ApplicationEvent {
    /**
     * 文章 ID
     */
    private Long articleId;

    public ReadArticleEvent(Object source, Long articleId) {
        super(source);
        this.articleId = articleId;
    }
}

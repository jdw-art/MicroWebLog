package com.jacob.weblog.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: Jacob
 * @Description: 文章删除事件
 * @Date: 2024-07-21 19:37
 * @Version: 1.0
 */
@Getter
public class DeleteArticleEvent extends ApplicationEvent {

    /**
     * 文章 ID
     */
    private Long articleId;

    public DeleteArticleEvent(Object source, Long articleId) {
        super(source);
        this.articleId = articleId;
    }
}

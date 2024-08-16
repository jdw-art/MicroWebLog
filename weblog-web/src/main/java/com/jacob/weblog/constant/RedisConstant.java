package com.jacob.weblog.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Jacob
 * @Description: redis 全局常量
 * @Date: 2024/8/16 15:21
 * @Version: 1.0
 */
public class RedisConstant {

    /**
     * 总排行榜
     */
    public static final String SORT_KEY = "article:sort";

    /**
     * 最近一天累计排行榜
     */
    public static final String SORT_DAY_PREFIX = "article:day:";

    /**
     * 最近一小时累计排行榜
     */
    public static final String SORT_HOUR_PREFIX = "article:hour:";

    /**
     * 获取总排行榜的key
     * @return
     */
    public static String getSortKey() {
        return SORT_KEY;
    }

    /**
     * 获取最近一天累计排行榜的key
     * @return
     */
    public static String getSortDayKey() {
        return SORT_DAY_PREFIX + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

    }

    /**
     * 获取最近一小时累计排行榜的key
     * @return
     */
    public static String getSortHourKey() {
        return SORT_HOUR_PREFIX + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
    }

    public static String getLastSortHourKey() {
        return SORT_HOUR_PREFIX + LocalDateTime.now().minusHours(1).format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
    }

    public static String getLastSortDayKey() {
        return SORT_DAY_PREFIX + LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}

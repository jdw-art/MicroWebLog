package com.jacob.weblog.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2024-07-20 16:53
 * @Version: 1.0
 */
@SpringBootTest
@Slf4j
public class RedisTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set key value
     */
    @Test
    void testSetKeyValue() {
        // 添加一个key为name，value为jacob
        redisTemplate.opsForValue().set("name", "jacob");
    }

    /**
     * 判断某个 key 是否存在
     */
    @Test
    void testHasKey() {
        log.info("key 是否存在：{}", Boolean.TRUE.equals(redisTemplate.hasKey("name")));
    }

    /**
     * 获取某个key 的 value
     */
    @Test
    void testGetValue() {
        log.info("value 的值为：{}", redisTemplate.opsForValue().get("name"));
    }

    /**
     * 删除某个key
     */
    @Test
    void testDelete() {
        redisTemplate.delete("name");
    }

}

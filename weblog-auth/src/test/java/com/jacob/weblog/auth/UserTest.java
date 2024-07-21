package com.jacob.weblog.auth;

import com.jacob.weblog.auth.domain.dataobject.UserDO;
import com.jacob.weblog.auth.domain.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2024-07-20 15:37
 * @Version: 1.0
 */
@SpringBootTest
@Slf4j
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        // 构建数据库实体类
        UserDO userDO = UserDO.builder()
                .username("犬小哈")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();

        userMapper.insert(userDO);
    }
}

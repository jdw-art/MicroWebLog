package com.jacob.weblog.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Jacob
 * @Description: 登录用户入参实体类
 * @Date: 2024-07-20 17:20
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginRepVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}

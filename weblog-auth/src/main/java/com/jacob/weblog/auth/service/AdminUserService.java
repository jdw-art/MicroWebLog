package com.jacob.weblog.auth.service;

import com.jacob.weblog.auth.model.LoginRspVO;
import com.jacob.weblog.auth.model.UpdateAdminUserPasswordReqVO;
import com.jacob.weblog.auth.model.UserLoginRepVO;
import com.jacob.weblog.framework.common.response.Response;

/**
 * @Author: Jacob
 * @Description: 用户业务接口
 * @Date: 2024-07-20 17:08
 * @Version: 1.0
 */
public interface AdminUserService {

    /**
     * 用户登录
     * @param userLoginRepVO
     * @return
     */
    LoginRspVO login(UserLoginRepVO userLoginRepVO);

    /**
     * 退出登录
     * @return
     */
    Response<?> logout();

    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();
}

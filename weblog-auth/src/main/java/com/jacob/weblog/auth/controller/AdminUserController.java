package com.jacob.weblog.auth.controller;

import com.jacob.weblog.auth.model.LoginRspVO;
import com.jacob.weblog.auth.model.UpdateAdminUserPasswordReqVO;
import com.jacob.weblog.auth.model.UserLoginRepVO;
import com.jacob.weblog.auth.service.AdminUserService;
import com.jacob.weblog.framework.biz.operationlog.aspect.ApiOperationLog;
import com.jacob.weblog.framework.common.response.Response;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Jacob
 * @Description: TODO
 * @Date: 2024-07-20 17:08
 * @Version: 1.0
 */
@RestController
@Slf4j
public class AdminUserController {

    @Resource
    private AdminUserService adminUserService;

    @PostMapping(value = "/login")
    @ApiOperationLog(description = "用户登录")
    public Response<LoginRspVO> login(@RequestBody UserLoginRepVO userLoginRepVO) {
        return Response.success(adminUserService.login(userLoginRepVO));
    }

    @PostMapping("/logout")
    @ApiOperationLog(description = "账号登出")
    public Response<?> logout() {

        return adminUserService.logout();
    }

    @PostMapping("/password/update")
    @ApiOperation(value = "修改用户密码")
    @ApiOperationLog(description = "修改用户密码")
    public Response updatePassword(@RequestBody @Validated UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        return adminUserService.updatePassword(updateAdminUserPasswordReqVO);
    }

    @PostMapping("/user/info")
    @ApiOperation(value = "获取用户信息")
    @ApiOperationLog(description = "获取用户信息")
    public Response findUserInfo() {
        return adminUserService.findUserInfo();
    }
}

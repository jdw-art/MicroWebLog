package com.jacob.weblog.auth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.jacob.weblog.auth.domain.dataobject.UserDO;
import com.jacob.weblog.auth.domain.mapper.UserMapper;
import com.jacob.weblog.auth.model.FindUserInfoRspVO;
import com.jacob.weblog.auth.model.LoginRspVO;
import com.jacob.weblog.auth.model.UpdateAdminUserPasswordReqVO;
import com.jacob.weblog.auth.model.UserLoginRepVO;
import com.jacob.weblog.auth.service.AdminUserService;
import com.jacob.weblog.framework.biz.context.holder.LoginUserContextHolder;
import com.jacob.weblog.framework.common.enums.ResponseCodeEnum;
import com.jacob.weblog.framework.common.exception.BizException;
import com.jacob.weblog.framework.common.response.Response;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Author: Jacob
 * @Description: 用户服务实现类
 * @Date: 2024-07-20 17:22
 * @Version: 1.0
 */
@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @Override
    public LoginRspVO login(UserLoginRepVO userLoginRepVO) {
        Long userId = null;

        String username = userLoginRepVO.getUsername();
        String password = userLoginRepVO.getPassword();

        UserDO userDO = userMapper.findByUsername(username);

        if (Objects.isNull(userDO)) {
            throw new BizException(ResponseCodeEnum.USERNAME_NOT_FOUND);
        }

        // 拿到密文密码
        String encodedPassword = userDO.getPassword();

        // 匹配密码是否一致
        boolean isPasswordCorrect = passwordEncoder.matches(password, encodedPassword);

        // 如果不正确，则抛出业务异常，提示用户名或密码不正确
        if (!isPasswordCorrect) {
            throw new BizException(ResponseCodeEnum.USERNAME_OR_PWD_ERROR);
        }

        userId = userDO.getId();

        // SaToken 登录用户，入参为用户ID
        StpUtil.login(userId);

        // 获取token
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        // 返回登录结果
        return LoginRspVO.builder().token(tokenInfo.tokenValue).build();
    }

    /**
     * 退出登录
     * @return
     */
    @Override
    public Response<?> logout() {
        Long userId = LoginUserContextHolder.getUserId();

        log.info("==> 用户退出登录, userId: {}", userId);

        threadPoolTaskExecutor.submit(() -> {
            Long userId2 = LoginUserContextHolder.getUserId();
            log.info("==> 异步线程中获取 userId: {}", userId2);
        });

        // 退出登录 (指定用户 ID)
        StpUtil.logout(userId);

        return Response.success();
    }

    @Override
    public Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        // 拿到用户名、密码
        String username = updateAdminUserPasswordReqVO.getUsername();
        String password = updateAdminUserPasswordReqVO.getPassword();

        // 加密密码
        String encodePassword = passwordEncoder.encode(password);

        // 更新到数据库
        int count = userMapper.updatePasswordByUsername(username, encodePassword);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
    }

    @Override
    public Response findUserInfo() {
        Long userId = LoginUserContextHolder.getUserId();

        log.info("==> 当前登录用户, userId: {}", userId);

        String username = userMapper.findById(userId).getUsername();

        return Response.success(FindUserInfoRspVO.builder().username(username).build());
    }
}

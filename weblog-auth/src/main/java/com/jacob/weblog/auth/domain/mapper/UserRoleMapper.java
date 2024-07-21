package com.jacob.weblog.auth.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jacob.weblog.auth.domain.dataobject.UserRoleDO;

import java.util.List;

/**
 * @Author: Jacob
 * @Description: 用户角色接口类
 * @Date: 2024-07-20 15:36
 * @Version: 1.0
 */
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    default List<UserRoleDO> selectByUsername(String username) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getUsername, username);

        return selectList(wrapper);
    }
}

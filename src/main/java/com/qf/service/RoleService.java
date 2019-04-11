package com.qf.service;

import com.qf.dto.RoleInfoDto;
import com.qf.pojo.RoleInfo;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public List<RoleInfoDto> getRoleByUserId(int userId);

    public Boolean updateUserRole(Map map);

    //查找所有角色
    public List<RoleInfo> selectAllRole(RoleInfo roleInfo);

}

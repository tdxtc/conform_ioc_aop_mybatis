package com.qf.mapper;

import com.qf.dto.RoleInfoDto;
import com.qf.pojo.RoleInfo;

import java.util.List;
import java.util.Map;

public interface RoleInfoMapper {
    public List<RoleInfoDto> getRoleByUserId(int userId);

    //修改用户
    public Integer updateStatus(Map map);

    //查询数据库中用户是否有对应的权限
    public int getRoleIsExist(Map map);

    //添加数据库中用户未添加选中的权限
    public Integer addRole(Map map);

    //查找所有角色
    public List<RoleInfo> selectAllRole(RoleInfo roleInfo);
}

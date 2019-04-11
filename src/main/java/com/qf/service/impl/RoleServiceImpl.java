package com.qf.service.impl;

import com.qf.dto.RoleInfoDto;
import com.qf.mapper.RoleInfoMapper;
import com.qf.pojo.RoleInfo;
import com.qf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleInfoMapper roleInfoMapper;

    //查询用户权限
    public List<RoleInfoDto> getRoleByUserId(int userId) {
        return roleInfoMapper.getRoleByUserId(userId);
    }

    //判断用户是否存在权限
    public Boolean updateUserRole(Map map) {
        Integer val = (Integer) map.get("val");
        Integer[] roleId = (Integer[]) map.get("roleId");

        int count = 0;
        for (int i = 0; i < roleId.length ; i++) {
            map.put("checkId", roleId[i]);
            //val=1 -> add
            if (val.equals(1)) {
                //不存在则添加
                if (this.roleInfoMapper.getRoleIsExist(map) == 0) {
                    count += this.roleInfoMapper.addRole(map);
                }
                //存在则修改
                else {
                    count += this.roleInfoMapper.updateStatus(map);
                }
            }
            //val=2 -> remove
            else if (val.equals(2)) {
                count += this.roleInfoMapper.updateStatus(map);
            }
        }
        return count == roleId.length;

    }

    public List<RoleInfo> selectAllRole(RoleInfo roleInfo) {
        return roleInfoMapper.selectAllRole(roleInfo);
    }

}

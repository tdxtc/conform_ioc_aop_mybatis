package com.qf.controller;

import com.qf.dto.RoleInfoDto;
import com.qf.pojo.RoleInfo;
import com.qf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "getRoleByUserId",method = RequestMethod.POST)
    public List<RoleInfoDto> getRoleByUserId(@RequestParam int userId){
        return roleService.getRoleByUserId(userId);
    }

    //查找所有的权限信息
    @ResponseBody
    @RequestMapping(value = "selectAllRole",method = RequestMethod.POST)
    public Object selectAllRole(@RequestBody(required = false) RoleInfo roleInfo){
        return roleService.selectAllRole(roleInfo);
    }


    @RequestMapping(value = "updateUserRole",method = RequestMethod.GET)
    public String updateUserRole(@RequestParam(value = "val",required = false) Integer val,
                                 @RequestParam(value = "userId",required = false) Integer userId,
                                 @RequestParam(value = "roleId[]",required = false) Integer[] roleId) {
        Boolean flag = false;
        Map<String, Object> map = new HashMap();
        map.put("val", val);
        map.put("userId", userId);
        map.put("roleId", roleId);
        if(roleId.length==0){
            return flag.toString();
        }
        flag = this.roleService.updateUserRole(map);
        return flag.toString();
    }
}

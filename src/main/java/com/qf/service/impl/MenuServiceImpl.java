package com.qf.service.impl;

import com.qf.dto.MenuInfoDto;
import com.qf.mapper.MenuInfoMapper;
import com.qf.service.MenuService;
import com.qf.vo.MenuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuInfoMapper menuInfoMapper;

    public List<MenuInfoDto> getAllMenu(int roleId) {
        return menuInfoMapper.getAllMenu(roleId);
    }

    public Boolean assignPermissionController(MenuInfoVo menuInfoVo) {
        int[] menuIds = menuInfoVo.getMenuIds();
        int roleId = menuInfoVo.getRoleId();

        System.out.println("roleId"+roleId);
        System.out.println("menuIds:"+menuIds);
        for (int i = 0; i < menuIds.length; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("roleId",roleId);
            map.put("menuId",menuIds[i]);
            //查询是否有权限
            System.out.println("单方事故");
            int i1 = menuInfoMapper.seleMenu(map);
            System.out.println(i1);
            if(1==i1){
                menuInfoMapper.assignPermissionController(map);
            }else{
                menuInfoMapper.assignPermissionController1(map);
            }
        }
        return true;
    }
}

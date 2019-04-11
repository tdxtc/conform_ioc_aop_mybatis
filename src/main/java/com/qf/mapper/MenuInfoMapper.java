package com.qf.mapper;

import com.qf.dto.MenuInfoDto;
import com.qf.vo.MenuInfoVo;

import java.util.List;
import java.util.Map;

public interface MenuInfoMapper {

    public List<MenuInfoDto> getAllMenu(int roleId);

    public Boolean assignPermissionController(Map map);

    public Boolean assignPermissionController1(Map map);

    public int seleMenu(Map map);


}

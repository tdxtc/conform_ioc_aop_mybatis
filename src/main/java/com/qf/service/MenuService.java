package com.qf.service;

import com.qf.dto.MenuInfoDto;
import com.qf.vo.MenuInfoVo;

import java.util.List;

public interface MenuService {

    public List<MenuInfoDto> getAllMenu(int roleId);

    public Boolean assignPermissionController(MenuInfoVo menuInfoVo);

}

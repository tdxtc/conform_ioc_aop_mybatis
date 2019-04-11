package com.qf.controller;


import com.qf.dto.MenuInfoDto;
import com.qf.service.MenuService;
import com.qf.vo.MenuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/getAllMenu",method = RequestMethod.POST)
    public Object getAllMenu(@RequestParam int roleId){
      //  System.out.println(menuService.AllMenuInfo(menuInfo));
        List<MenuInfoDto> allMenu = menuService.getAllMenu(roleId);
        return this.menuService.getAllMenu(roleId);
    }

    @ResponseBody
    @RequestMapping(value = "/assignPermissionController",method = RequestMethod.POST)
    public String assignPermissionController(@RequestBody MenuInfoVo menuInfoVo){
        Boolean flag = menuService.assignPermissionController(menuInfoVo);
        return flag.toString();
    }
}

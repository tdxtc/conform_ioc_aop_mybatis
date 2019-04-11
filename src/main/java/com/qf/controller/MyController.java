package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.UserInfo;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
public class MyController {

    @Autowired
    UserService userService;
    //登录验证
    @ResponseBody
    @RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
    public String loginCheck(@RequestBody UserInfo userInfo){
        Boolean flag = false;
//        System.out.println("username="+userInfo.getUsername()+",password="+userInfo.getPassword());

        flag = userService.loginCheck(userInfo);
        return flag.toString();
    }
    //展示用户
    @ResponseBody
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public Object select(@RequestBody(required = false) UserInfo userInfo){
        PageHelper.startPage(userInfo.getCurrentPage(), userInfo.getPageSize());
        List<UserInfo> select = userService.select(userInfo);
        PageInfo<UserInfo> studentPageInfo = new PageInfo<UserInfo>(select);
        return studentPageInfo;
    }
    //修改用户信息
    @ResponseBody
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(@RequestBody(required = false) UserInfo userInfo){
        Boolean flag = false;
        flag = userService.updateUser(userInfo);
        return flag.toString();
    }
    //查找用户
    @ResponseBody
    @RequestMapping(value = "/selectfind",method = RequestMethod.POST)
    public Object selectfind(@RequestBody UserInfo userInfo){
        List<UserInfo> select = userService.select(userInfo);
        return select;
    }



//@RequestParam 单个

    @ResponseBody
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.POST)
    public List<UserInfo>  selectByUserId(@RequestBody(required = false) UserInfo userInfo){
        List<UserInfo> selectByUserId = userService.selectByUserId(userInfo);
        return selectByUserId;
    }

    //添加用户
    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestBody(required = false) UserInfo userInfo){
        Boolean flag = false;
        flag = userService.addUser(userInfo);
        return flag.toString();
    }

    //删除用户
    @ResponseBody
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public String deleteUser(@RequestBody(required = false) UserInfo userInfo){
        Boolean flag = false;
        flag = userService.deleteUser(userInfo);
        return flag.toString();
    }
    //批量删除
    @RequestMapping("/bechdel")
    public String bechdel(Integer[] ids) {
        HashMap<String,Object> map = new HashMap();
        map.put("ids",ids);
        Boolean flag = userService.bechdel(map);
        return flag.toString();
    }
}

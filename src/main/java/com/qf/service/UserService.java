package com.qf.service;

import com.qf.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    //登录验证
    public boolean loginCheck(UserInfo userInfo);

    //添加操作
    public boolean addUser(UserInfo userInfo);

    //删除操作
    public boolean deleteUser(UserInfo userInfo);

    //修改操作
    public boolean updateUser(UserInfo userInfo);

    //查询操作
    public List<UserInfo> select(UserInfo userInfo);

    //查询单个用户操作
    public List<UserInfo> selectByUserId(UserInfo userInfo);

    //批量删除
    public Boolean bechdel(Map map);
}

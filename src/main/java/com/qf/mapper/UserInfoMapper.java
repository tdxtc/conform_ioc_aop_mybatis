package com.qf.mapper;

import com.qf.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    //登录验证
    public UserInfo loginCheck(UserInfo userInfo);

    //添加操作
    public int addUser(UserInfo userInfo);

    //删除操作
    public int deleteUser(UserInfo userInfo);

    //修改操作
    public int updateUser(UserInfo userInfo);

    //查询全部用户操作
    public List<UserInfo> select(UserInfo userInfo);

    //查询单个用户操作
    public List<UserInfo> selectByUserId(UserInfo userInfo);

    //批量删除
    public Integer bechdel(Map map);
}

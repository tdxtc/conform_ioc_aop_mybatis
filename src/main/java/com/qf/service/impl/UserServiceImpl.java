package com.qf.service.impl;

import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.UserInfo;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public boolean loginCheck(UserInfo userInfo) {
        if(userInfoMapper.loginCheck(userInfo)!=null){
            return true;
        }
        return false;
    }

    public boolean addUser(UserInfo userInfo){
        int count = userInfoMapper.addUser(userInfo);
        if(count>0){
            return true;
        }
        return false;
    }

    public boolean deleteUser(UserInfo userInfo) {
        int count = userInfoMapper.deleteUser(userInfo);
        if(count>0){
            return true;
        }
        return false;
    }

    public boolean updateUser(UserInfo userInfo){
        int count = userInfoMapper.updateUser(userInfo);
        if(count>0){
            return true;
        }
        return false;
    }

    public List<UserInfo> select(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    public List<UserInfo> selectByUserId(UserInfo userInfo) {
        return userInfoMapper.selectByUserId(userInfo);
    }

    public Boolean bechdel(Map map) {
      if(userInfoMapper.bechdel(map)>0){
          return true;
      }
      return false;
    }
}

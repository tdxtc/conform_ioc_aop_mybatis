package com.qf.pojo;

import java.util.Arrays;

/**
 * Created by DELL on 2019/3/21.
 */
public class RoleInfo {
    int roleId;
    String roleName;
    String userName;
    String[] ids;
    int userId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return roleName;
    }

    public void setRolename(String rolename) {
        this.roleName = rolename;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", rolename='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                ", ids=" + Arrays.toString(ids) +
                ", userId=" + userId +
                '}';
    }
}

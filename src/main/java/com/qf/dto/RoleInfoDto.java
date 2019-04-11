package com.qf.dto;

public class RoleInfoDto {
    int roleId;
    String roleName;
    int userId;

    public RoleInfoDto(){

    }
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RoleInfoDto{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userId=" + userId +
                '}';
    }
}

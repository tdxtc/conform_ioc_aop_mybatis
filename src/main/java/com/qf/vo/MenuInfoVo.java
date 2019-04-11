package com.qf.vo;

import java.util.Arrays;

public class MenuInfoVo {
    int roleId;
    int[] menuIds;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(int[] menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "MenuInfoVo{" +
                "roleId=" + roleId +
                ", menuIds=" + Arrays.toString(menuIds) +
                '}';
    }
}

package com.ortegamiguel.usuariospaqueteria.service.utils;

public enum RoleEnum {

    GERENTE("ROLE_GERENTE", 1),
    COORDINADOR("ROLE_COORDINADOR", 2),
    SUPERVISOR("ROLE_SUPERVISOR", 3);

    private String roleName;
    private int roleId;

    RoleEnum(String roleName, int roleId) {
        this.roleName = roleName;
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public static String getRoleName(int roleId) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.roleId == roleId) {
                return role.roleName;
            }
        }
        return null;
    }
}

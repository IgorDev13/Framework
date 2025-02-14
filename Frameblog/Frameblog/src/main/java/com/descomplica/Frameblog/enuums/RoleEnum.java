package com.descomplica.Frameblog.enuums;

public enum RoleEnum {

    ADMIN("admin"),
    USER("user");

    private final String role;

    RoleEnum(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

package com.easytrip.easytrip.Security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    TRAVEL_READ("travel:read"),
    TRAVEL_WRITE("travel:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

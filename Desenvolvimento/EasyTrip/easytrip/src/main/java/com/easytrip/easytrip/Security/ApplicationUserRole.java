package com.easytrip.easytrip.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.easytrip.easytrip.Security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet(USER_READ,USER_WRITE)),
    USER_BLOCKED(Sets.newHashSet(USER_READ)),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE,TRAVEL_READ,TRAVEL_WRITE));

    private final Set<com.easytrip.easytrip.Security.ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<com.easytrip.easytrip.Security.ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<com.easytrip.easytrip.Security.ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}

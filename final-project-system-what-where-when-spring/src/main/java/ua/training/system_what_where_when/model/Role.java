package ua.training.system_what_where_when.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_PLAYER, ROLE_REFEREE;

    @Override
    public String getAuthority() {
        return name();
    }
}

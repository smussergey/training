package ua.training.system_what_where_when.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {

    private final Long id;
    private final String nameUa;
    private final String nameEn;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            Long id,
            String nameUa,
            String nameEn,
            String email,
            String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nameUa = nameUa;
        this.nameEn = nameEn;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNameUa() {
        return nameUa;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}

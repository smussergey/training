package ua.training.system_what_where_when.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ua.training.system_what_where_when.model.Role;
import ua.training.system_what_where_when.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getNameUa(),
                user.getNameEn(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}

package io.flats.JWT_AUTH.jwt;


import io.flats.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class JwtUserFactory {
    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                new SimpleGrantedAuthority(user.getRole().getName()));
    }
}
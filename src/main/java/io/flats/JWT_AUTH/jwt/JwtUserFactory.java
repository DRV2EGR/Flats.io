package io.flats.JWT_AUTH.jwt;


import io.flats.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * The type Jwt user factory.
 */
public class JwtUserFactory {
    /**
     * Create jwt user.
     *
     * @param user the user
     * @return the jwt user
     */
    public static JwtUser create(User user) {
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                new SimpleGrantedAuthority(user.getRole().getName()));
    }
}
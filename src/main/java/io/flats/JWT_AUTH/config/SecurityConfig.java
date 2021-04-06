package io.flats.JWT_AUTH.config;


import io.flats.JWT_AUTH.jwt.JwtConfigurer;
import io.flats.JWT_AUTH.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * The type Security config.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // SERVICE ENDPOINTS
    private static final String CHECK_STABILITY_ENDPOINT = "/api/check_stability/**";

    // AUTH ENDPOINTS
    private static final String AUTH_ENDPOINT = "/api/auth/**";
    private static final String SIGNUP_ENDPOINT = "/api/signup/**";

    // USER CABINET ENDPOINTS
//private static final String PUBLIC_USERS_ENDPOINT = "/api/user/**";
    private static final String PRIVATE_USERS_ENDPOINT = "/api/user/**";



    private static final String ADMIN_ENDPOINT = "/api/admin/**";

    private static final String MAIN_PAGES_ENDPOINT = "/api/service/**";
    //private static final String PUBLIC_USERS_ENDPOINT = "/api/user/**";
    //private static final String PRIVATE_USERS_ENDPOINT = "/api/user/**";

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * Instantiates a new Security config.
     *
     * @param jwtTokenProvider the jwt token provider
     */
    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers(AUTH_ENDPOINT).permitAll()
                    .antMatchers(SIGNUP_ENDPOINT).permitAll()
                    .antMatchers(MAIN_PAGES_ENDPOINT).permitAll()
                    //.antMatchers(PUBLIC_USERS_ENDPOINT).permitAll()
                    .antMatchers(PRIVATE_USERS_ENDPOINT).hasAnyRole("ADMIN", "SELLER", "REALTOR")
                    .antMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                    .antMatchers("/api/flats/get_flat").permitAll()
                    .anyRequest().authenticated()
                .and()
                .formLogin().disable()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}

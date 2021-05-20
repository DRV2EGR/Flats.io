package io.flats.JWT_AUTH.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Comments;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class, JwtUserDetailsService.class})
@ExtendWith(SpringExtension.class)
public class JwtUserDetailsServiceTest {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private UserService userService;

    @Test
    public void testLoadUserByUsername() throws UsernameNotFoundException {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByUsername(anyString())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.jwtUserDetailsService.loadUserByUsername("janedoe");
        Collection<? extends GrantedAuthority> authorities = actualLoadUserByUsernameResult.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("Name", ((ArrayList<? extends GrantedAuthority>) authorities).get(0).getAuthority());
        verify(this.userService).findByUsername(anyString());
    }

    @Test
    public void testLoadUserByUsername2() throws UsernameNotFoundException {
        Role role = new Role();
        role.setId(123L);
        role.setName("NAME");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setPuttedLikesToFlats(new ArrayList<Likes>());
        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
        user.setRating(10.0f);
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByUsername(anyString())).thenReturn(ofResult);
        this.jwtUserDetailsService.loadUserByUsername("janedoe");
        verify(this.userService).findByUsername(anyString());
    }

    @Test
    public void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(this.userService.findByUsername(anyString())).thenReturn(Optional.<User>empty());
        assertThrows(UsernameNotFoundException.class, () -> this.jwtUserDetailsService.loadUserByUsername("janedoe"));
        verify(this.userService).findByUsername(anyString());
    }
}


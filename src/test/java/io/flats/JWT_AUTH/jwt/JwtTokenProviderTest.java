package io.flats.JWT_AUTH.jwt;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.flats.JWT_AUTH.entity.RefreshToken;
import io.flats.JWT_AUTH.repository.RefreshTokenRepository;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Role;
import io.flats.entity.User;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {JwtTokenProvider.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTokenProviderTest {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private RefreshTokenRepository refreshTokenRepository;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateAccessToken() {
        Role role = new Role();
        role.setId(123L);
        role.setName("role");

        User user = new User(1L, "janedoe");
        user.setRole(role);
        Assertions.assertNotNull(this.jwtTokenProvider.createAccessToken(user));
    }

    @Test
    public void testCreateAccessToken2() {
        Role role = new Role();
        role.setId(123L);
        role.setName("role");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("role");
        user.setUsername("janedoe");
        user.setSecondName("role");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);
        Assertions.assertNotNull(this.jwtTokenProvider.createAccessToken(user));
    }

    @Test
    public void testCreateAccessToken3() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = mock(User.class);
        when(user.getRole()).thenReturn(role);
        when(user.getUsername()).thenReturn("foo");
        Assertions.assertNotNull(this.jwtTokenProvider.createAccessToken(user));
    }

    @Test
    public void testCreateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken("ABC123");
        refreshToken.setUserId(123L);
        when(this.refreshTokenRepository.save((RefreshToken) any())).thenReturn(refreshToken);
        Assertions.assertNotNull(this.jwtTokenProvider.createRefreshToken(-1L));
    }

    @Test
    public void testResolveAccessToken() {
        assertNull(this.jwtTokenProvider.resolveAccessToken(new MockHttpServletRequest()));
        assertNull(this.jwtTokenProvider
                .resolveAccessToken(new MockHttpServletRequest("https://example.org/example", "https://example.org/example")));
    }

    @Test
    public void testValidateAccessToken() {
        assertFalse(this.jwtTokenProvider.validateAccessToken("ABC123"));
        assertFalse(this.jwtTokenProvider.validateAccessToken("Token"));
    }

    @Test
    public void testValidateRefreshToken() {
        assertFalse(this.jwtTokenProvider.validateRefreshToken("ABC123"));
        assertFalse(this.jwtTokenProvider.validateRefreshToken("Token"));
    }

//    @Test
//    public void testGetAuthentication() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        this.jwtTokenProvider.getAuthentication("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.PcmVIPbcZl9j7qFzXRAeSyhtuBnHQNMuLHsaG5l804A");
//    }

    @Test
    public void testGetAuthentication2() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = new User(20L, "awd"); user.setRole(role);

        when(jwtUserDetailsService.loadUserByUsername(any())).thenReturn(new JwtUser("awd","pass", new SimpleGrantedAuthority("ADMIN")));

        String tiktok = this.jwtTokenProvider.createAccessToken(user);
        assertNotNull(this.jwtTokenProvider.getAuthentication(tiktok));
    }

    @Test
    public void testRefreshPairOfTokens() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = new User(20L, "awd"); user.setRole(role);


        RefreshToken rt = new RefreshToken();
        rt.setRefreshToken(this.jwtTokenProvider.createRefreshToken(user.getId()));
        when(this.refreshTokenRepository.findById(any())).thenReturn(java.util.Optional.of(rt));
        when(this.userService.findById(any())).thenReturn(java.util.Optional.of(user));

        assertNotNull(this.jwtTokenProvider.refreshPairOfTokens(rt.getRefreshToken()));
    }
}


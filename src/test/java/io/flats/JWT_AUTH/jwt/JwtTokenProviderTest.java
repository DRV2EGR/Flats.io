package io.flats.JWT_AUTH.jwt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.flats.JWT_AUTH.entity.RefreshToken;
import io.flats.JWT_AUTH.repository.RefreshTokenRepository;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Comments;
import io.flats.entity.Likes;
import io.flats.entity.Role;
import io.flats.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtTokenProvider.class})
@ExtendWith(SpringExtension.class)
public class JwtTokenProviderTest {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private RefreshTokenRepository refreshTokenRepository;

    @MockBean
    private UserService userService;
//
//    @Test
//    public void testCreateAccessToken() {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("role");
//
//        User user = new User(1L, "janedoe");
//        user.setRole(role);
//        assertNull(this.jwtTokenProvider.createAccessToken(user));
//    }
//
//    @Test
//    public void testCreateAccessToken2() {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("role");
//
//        User user = new User();
//        user.setLastName("Doe");
//        user.setEmail("jane.doe@example.org");
//        user.setPassword("iloveyou");
//        user.setActivationCode("role");
//        user.setId(123L);
//        user.setPhoneNumber("4105551212");
//        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
//        user.setUserProfileImageUrl("https://example.org/example");
//        user.setFirstName("Jane");
//        user.setReceivedCommentsToFlats(new ArrayList<Comments>());
//        user.setUsername("janedoe");
//        user.setSecondName("role");
//        user.setPuttedLikesToFlats(new ArrayList<Likes>());
//        user.setPuttedCommentsToFlats(new ArrayList<Comments>());
//        user.setRating(10.0f);
//        user.setRole(role);
//        assertNull(this.jwtTokenProvider.createAccessToken(user));
//    }
//
//    @Test
//    public void testCreateAccessToken3() {
//        Role role = new Role();
//        role.setId(123L);
//        role.setName("Name");
//        User user = mock(User.class);
//        when(user.getRole()).thenReturn(role);
//        when(user.getUsername()).thenReturn("foo");
//        assertNull(this.jwtTokenProvider.createAccessToken(user));
//    }
//
//    @Test
//    public void testCreateRefreshToken() {
//        RefreshToken refreshToken = new RefreshToken();
//        refreshToken.setRefreshToken("ABC123");
//        refreshToken.setUserId(123L);
//        when(this.refreshTokenRepository.save((RefreshToken) any())).thenReturn(refreshToken);
//        assertNull(this.jwtTokenProvider.createRefreshToken(-1L));
//    }
//
//    @Test
//    public void testResolveAccessToken() {
//        assertNull(this.jwtTokenProvider.resolveAccessToken(new MockHttpServletRequest()));
//        assertNull(this.jwtTokenProvider
//                .resolveAccessToken(new MockHttpServletRequest("https://example.org/example", "https://example.org/example")));
//    }
//
//    @Test
//    public void testValidateAccessToken() {
//        assertFalse(this.jwtTokenProvider.validateAccessToken("ABC123"));
//        assertFalse(this.jwtTokenProvider.validateAccessToken("Token"));
//    }
//
//    @Test
//    public void testValidateRefreshToken() {
//        assertFalse(this.jwtTokenProvider.validateRefreshToken("ABC123"));
//        assertFalse(this.jwtTokenProvider.validateRefreshToken("Token"));
//    }
//
//    @Test
//    public void testGetAuthentication() {
//        // TODO: This test is incomplete.
//        //   Reason: No meaningful assertions found.
//        //   To help Diffblue Cover to find assertions, please add getters to the
//        //   class under test that return fields written by the method under test.
//        //   See https://diff.blue/R004
//
//        this.jwtTokenProvider.getAuthentication("ABC123");
//    }
//
//    @Test
//    public void testGetAuthentication2() {
//        assertNull(this.jwtTokenProvider.getAuthentication("Token"));
//    }
//
//    @Test
//    public void testRefreshPairOfTokens() {
//        assertNull(this.jwtTokenProvider.refreshPairOfTokens("Refresh Token String"));
//    }
}


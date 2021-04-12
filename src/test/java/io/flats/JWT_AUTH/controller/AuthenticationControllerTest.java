package io.flats.JWT_AUTH.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.flats.JWT_AUTH.dto.AuthenticationRequestDto;
import io.flats.JWT_AUTH.dto.JwtAuthDto;
import io.flats.JWT_AUTH.jwt.JwtTokenProvider;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.Role;
import io.flats.entity.User;

import java.time.LocalDateTime;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthenticationController.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthenticationControllerTest {
    @Autowired
    private AuthenticationController authenticationController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    private UserService userService;

    @Test
    public void testLogin() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByEmail(anyString())).thenReturn(ofResult);
        when(this.jwtTokenProvider.createRefreshToken(anyLong())).thenReturn("foo");
        when(this.jwtTokenProvider.createAccessToken((User) any())).thenReturn("foo");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        authenticationRequestDto.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers
                                .containsString("{\"username\":\"janedoe\",\"accessToken\":\"foo\",\"refreshToken\":\"foo\"}")));
    }

    @Test
    public void testLogin2() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);
        Optional<User> ofResult = Optional.<User>of(user);
        when(this.userService.findByEmail(anyString())).thenReturn(ofResult);
        when(this.jwtTokenProvider.createRefreshToken(anyLong())).thenThrow(new IllegalArgumentException("foo"));
        when(this.jwtTokenProvider.createAccessToken((User) any())).thenReturn("foo");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        authenticationRequestDto.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void testLogin3() throws Exception {
        when(this.userService.findByEmail(anyString())).thenReturn(Optional.<User>empty());
        when(this.jwtTokenProvider.createRefreshToken(anyLong())).thenReturn("foo");
        when(this.jwtTokenProvider.createAccessToken((User) any())).thenReturn("foo");
        when(this.authenticationManager.authenticate((org.springframework.security.core.Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        AuthenticationRequestDto authenticationRequestDto = new AuthenticationRequestDto();
        authenticationRequestDto.setEmail("jane.doe@example.org");
        authenticationRequestDto.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void testRefresh() throws Exception {
        when(this.jwtTokenProvider.refreshPairOfTokens(anyString())).thenReturn(new JwtAuthDto());

        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");
        jwtAuthDto.setAccessToken("ABC123");
        jwtAuthDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(jwtAuthDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/auth/refresh")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"username\":null,\"accessToken\":null,\"refreshToken\":null}")));
    }
}


package io.flats.JWT_AUTH.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponseWrapper;
import io.flats.JWT_AUTH.config.SecurityConfig;
import io.flats.entity.Role;
import io.flats.entity.User;
import org.apache.catalina.connector.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtTokenFilterTest {

    @MockBean
    JwtTokenFilter jwtTokenFilter;

    @Spy
    @InjectMocks
    JwtTokenProvider jwtTokenProvider;

    @Test
    public void doFilter() throws ServletException, IOException {

        jwtTokenFilter.doFilter(
                new MockHttpServletRequest(),
                new ServletResponseWrapper(new Response()),
                new MockFilterChain()
        );
    }

    @Test
    public void doFilter1() throws ServletException, IOException {

//        MockHttpServletRequest request = new MockHttpServletRequest();
//        request.addHeader(TOKEN, token);
//        request.setRequestURI(testUri);
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        MockFilterChain filterChain = new MockFilterChain();
////        when(securityService.doesExistToken(token)).thenReturn(true);
////        tokenAuthenticationFilter.doFilterInternal(request, response, filterChain);
////        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//

        MockHttpServletRequest request = new MockHttpServletRequest();
//        request.setServerName("www.example.com");
        request.setRequestURI("/api/admin/");
        request.setQueryString("");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = new User(20L, "awd"); user.setRole(role);

        String at = jwtTokenProvider.createAccessToken(user);
        request.addHeader("Authorization", "Bearer " + at);


        MockHttpServletResponse response = new MockHttpServletResponse();
        jwtTokenFilter.doFilter(
                request,
                response,
                new MockFilterChain()
        );

//        Mockito.verify(this.jwtTokenProvider, times(1))
//                .getAuthentication(anyString());
        assert(response.getStatus() == 200);
    }

}
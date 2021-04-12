package io.flats.JWT_AUTH.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponseWrapper;
import io.flats.entity.Role;
import io.flats.entity.User;
import org.apache.catalina.connector.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtTokenFilterTest {

    @MockBean
    JwtTokenFilter jwtTokenFilter;

    @Autowired
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

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setServerName("www.example.com");
        request.setRequestURI("/foo");
        request.setQueryString("");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        User user = new User(20L, "awd"); user.setRole(role);
        String at = jwtTokenProvider.createAccessToken(user);
        request.addHeader("Authorization", "Bearer " + at);


        jwtTokenFilter.doFilter(
                request,
                new ServletResponseWrapper(new Response()),
                new MockFilterChain()
        );
    }
}
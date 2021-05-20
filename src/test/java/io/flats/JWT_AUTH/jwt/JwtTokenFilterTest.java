package io.flats.JWT_AUTH.jwt;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.flats.JWT_AUTH.service.UserService;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class JwtTokenFilterTest {
    @Test
    public void testDoFilter() throws IOException, ServletException {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(
                new JwtTokenProvider(new JwtUserDetailsService(new UserService())));
        MockHttpServletRequest servletRequest = new MockHttpServletRequest();
        Response servletResponse = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        jwtTokenFilter.doFilter(servletRequest, servletResponse, filterChain);
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }
}


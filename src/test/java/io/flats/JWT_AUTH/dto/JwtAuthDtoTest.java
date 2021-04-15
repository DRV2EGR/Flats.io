package io.flats.JWT_AUTH.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtAuthDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new JwtAuthDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        assertTrue(jwtAuthDto.canEqual(new JwtAuthDto()));
    }

    @Test
    public void testEquals() {
        assertFalse((new JwtAuthDto()).equals("42"));
    }

    @Test
    public void testEquals2() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        assertTrue(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals3() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");
        assertFalse(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals4() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setAccessToken("ABC123");
        assertFalse(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals5() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setUsername("janedoe");
        assertFalse(jwtAuthDto.equals(new JwtAuthDto()));
    }

    @Test
    public void testEquals6() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setRefreshToken("ABC123");
        assertFalse(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testEquals7() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setAccessToken("ABC123");
        assertFalse(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testEquals8() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();

        JwtAuthDto jwtAuthDto1 = new JwtAuthDto();
        jwtAuthDto1.setUsername("janedoe");
        assertFalse(jwtAuthDto.equals(jwtAuthDto1));
    }

    @Test
    public void testHashCode() {
        assertEquals(357642, (new JwtAuthDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");
        assertEquals(1924249487, jwtAuthDto.hashCode());
    }

    @Test
    public void testHashCode3() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setAccessToken("ABC123");
        assertEquals(1840826801, jwtAuthDto.hashCode());
    }

    @Test
    public void testHashCode4() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setUsername("janedoe");
        assertEquals(592859843, jwtAuthDto.hashCode());
    }

    @Test
    public void testSetAccessToken() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setAccessToken("ABC123");
        assertEquals("ABC123", jwtAuthDto.getAccessToken());
    }

    @Test
    public void testSetRefreshToken() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setRefreshToken("ABC123");
        assertEquals("ABC123", jwtAuthDto.getRefreshToken());
    }

    @Test
    public void testSetUsername() {
        JwtAuthDto jwtAuthDto = new JwtAuthDto();
        jwtAuthDto.setUsername("janedoe");
        assertEquals("janedoe", jwtAuthDto.getUsername());
    }

    @Test
    public void testToString() {
        assertEquals("JwtAuthDto(username=null, accessToken=null, refreshToken=null)", (new JwtAuthDto()).toString());
    }
}


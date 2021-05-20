package io.flats.JWT_AUTH.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RefreshTokenTest {
    @Test
    public void testConstructor() {
        RefreshToken actualRefreshToken = new RefreshToken(123L, "ABC123");
        assertEquals("ABC123", actualRefreshToken.getRefreshToken());
        assertEquals(123L, actualRefreshToken.getUserId());
    }
}


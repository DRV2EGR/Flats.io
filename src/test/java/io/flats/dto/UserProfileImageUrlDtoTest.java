package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserProfileImageUrlDtoTest {
    @Test
    public void testConstructor() {
        assertEquals("https://example.org/example", (new UserProfileImageUrlDto("https://example.org/example")).getImg());
    }
}


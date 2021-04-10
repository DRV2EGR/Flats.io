package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserProfileImageUrlDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new UserProfileImageUrlDto("https://example.org/example")).canEqual("Other"));
        assertFalse((new UserProfileImageUrlDto("https://example.org/example")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("https://example.org/example");
        assertTrue(userProfileImageUrlDto.canEqual(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testCanEqual3() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("https://example.org/example");
        assertTrue(userProfileImageUrlDto.canEqual(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testEquals() {
        assertFalse((new UserProfileImageUrlDto("https://example.org/example")).equals("42"));
        assertFalse((new UserProfileImageUrlDto("https://example.org/example")).equals("42"));
    }

    @Test
    public void testEquals2() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("https://example.org/example");
        assertTrue(userProfileImageUrlDto.equals(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testEquals3() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto(null);
        assertFalse(userProfileImageUrlDto.equals(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testEquals4() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("Img");
        assertFalse(userProfileImageUrlDto.equals(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testEquals5() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto(null);
        assertTrue(userProfileImageUrlDto.equals(new UserProfileImageUrlDto(null)));
    }

    @Test
    public void testEquals6() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("https://example.org/example");
        assertTrue(userProfileImageUrlDto.equals(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testEquals7() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto(null);
        assertFalse(userProfileImageUrlDto.equals(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testEquals8() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("Img");
        assertFalse(userProfileImageUrlDto.equals(new UserProfileImageUrlDto("https://example.org/example")));
    }

    @Test
    public void testEquals9() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto(null);
        assertTrue(userProfileImageUrlDto.equals(new UserProfileImageUrlDto(null)));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1485029433, (new UserProfileImageUrlDto("https://example.org/example")).hashCode());
        assertEquals(102, (new UserProfileImageUrlDto(null)).hashCode());
        assertEquals(-1485029433, (new UserProfileImageUrlDto("https://example.org/example")).hashCode());
        assertEquals(102, (new UserProfileImageUrlDto(null)).hashCode());
    }

    @Test
    public void testSetImg() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("https://example.org/example");
        userProfileImageUrlDto.setImg("https://example.org/example");
        assertEquals("https://example.org/example", userProfileImageUrlDto.getImg());
    }

    @Test
    public void testSetImg2() {
        UserProfileImageUrlDto userProfileImageUrlDto = new UserProfileImageUrlDto("https://example.org/example");
        userProfileImageUrlDto.setImg("https://example.org/example");
        assertEquals("https://example.org/example", userProfileImageUrlDto.getImg());
    }

    @Test
    public void testToString() {
        assertEquals("UserProfileImageUrlDto(img=https://example.org/example)",
                (new UserProfileImageUrlDto("https://example.org/example")).toString());
        assertEquals("UserProfileImageUrlDto(img=https://example.org/example)",
                (new UserProfileImageUrlDto("https://example.org/example")).toString());
    }
}


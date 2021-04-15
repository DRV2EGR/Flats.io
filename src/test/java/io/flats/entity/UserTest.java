package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Test
    public void testConstructor() {
        User actualUser = new User(123L, "janedoe");
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals(123L, actualUser.getId());
    }

    @Test
    public void testToString() {
        assertEquals("User{id=123, email='null'}", (new User(123L, "janedoe")).toString());
    }
}


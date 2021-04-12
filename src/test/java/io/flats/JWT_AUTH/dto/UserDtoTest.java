package io.flats.JWT_AUTH.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.flats.entity.Role;
import io.flats.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDtoTest {
    @Test
    public void testConstructor() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(123L, "janedoe");
        user.setRole(role);
        UserDto actualUserDto = new UserDto(user);
        assertNull(actualUserDto.getEmail());
        assertEquals("janedoe", actualUserDto.getUsername());
        assertNull(actualUserDto.getSecondName());
        assertEquals("Name", actualUserDto.getRole());
        assertNull(actualUserDto.getPhoneNumber());
        assertNull(actualUserDto.getLastName());
        assertNull(actualUserDto.getFirstName());
    }
}


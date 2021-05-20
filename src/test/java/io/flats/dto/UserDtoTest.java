package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import io.flats.entity.Role;
import io.flats.entity.User;
import org.junit.jupiter.api.Test;

public class UserDtoTest {
    @Test
    public void testConstructor() {
        UserDto actualUserDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertEquals("janedoe", actualUserDto.getUsername());
        assertEquals("Second Name", actualUserDto.getSecondName());
        assertEquals("Role", actualUserDto.getRole());
        assertEquals("4105551212", actualUserDto.getPhoneNumber());
        assertEquals("Doe", actualUserDto.getLastName());
        assertEquals("Jane", actualUserDto.getFirstName());
        assertEquals("jane.doe@example.org", actualUserDto.getEmail());
    }

    @Test
    public void testConstructor2() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User(123L, "janedoe");
        user.setRole(role);
        UserDto actualUserDto = new UserDto(user);
        assertEquals("janedoe", actualUserDto.getUsername());
        assertNull(actualUserDto.getSecondName());
        assertEquals("Name", actualUserDto.getRole());
        assertNull(actualUserDto.getPhoneNumber());
        assertNull(actualUserDto.getLastName());
        assertNull(actualUserDto.getFirstName());
        assertNull(actualUserDto.getEmail());
    }
}


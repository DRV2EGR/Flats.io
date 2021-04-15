package io.flats.JWT_AUTH.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.flats.entity.Role;
import io.flats.entity.User;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDtoFactoryTest {
    @Test
    public void testCreateUserDto() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setLastName("Doe");
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivationCode("Activation Code");
        user.setUsername("janedoe");
        user.setSecondName("Second Name");
        user.setId(123L);
        user.setPhoneNumber("4105551212");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setFirstName("Jane");
        user.setRole(role);
        UserDto actualCreateUserDtoResult = UserDtoFactory.createUserDto(user);
        assertEquals("jane.doe@example.org", actualCreateUserDtoResult.getEmail());
        assertEquals("janedoe", actualCreateUserDtoResult.getUsername());
        assertEquals("Second Name", actualCreateUserDtoResult.getSecondName());
        assertEquals("Name", actualCreateUserDtoResult.getRole());
        assertEquals("4105551212", actualCreateUserDtoResult.getPhoneNumber());
        assertEquals("Doe", actualCreateUserDtoResult.getLastName());
        assertEquals("Jane", actualCreateUserDtoResult.getFirstName());
    }
}


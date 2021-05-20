package io.flats.JWT_AUTH.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserDtoPayloadTest {
    @Test
    public void testConstructor() {
        UserDtoPayload actualUserDtoPayload = new UserDtoPayload("Jane", "Second Name", "Doe", "janedoe",
                "jane.doe@example.org", "iloveyou", "4105551212", "https://example.org/example");
        assertEquals("jane.doe@example.org", actualUserDtoPayload.getEmail());
        assertEquals("janedoe", actualUserDtoPayload.getUsername());
        assertEquals("https://example.org/example", actualUserDtoPayload.getUserProfileImageUrl());
        assertEquals("Second Name", actualUserDtoPayload.getSecondName());
        assertEquals("4105551212", actualUserDtoPayload.getPhoneNumber());
        assertEquals("iloveyou", actualUserDtoPayload.getPassword());
        assertEquals("Doe", actualUserDtoPayload.getLastName());
        assertEquals("Jane", actualUserDtoPayload.getFirstName());
    }
}


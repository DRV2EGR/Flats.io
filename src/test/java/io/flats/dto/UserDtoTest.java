package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))
                .canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertTrue(userDto
                .canEqual(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals() {
        assertFalse((new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))
                .equals("42"));
    }

    @Test
    public void testEquals10() {
        UserDto userDto = new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto.equals(new UserDto()));
    }

    @Test
    public void testEquals11() {
        UserDto userDto = new UserDto();
        assertTrue(userDto.equals(new UserDto()));
    }

    @Test
    public void testEquals2() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertTrue(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals3() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertFalse(userDto.equals(new UserDto()));
    }

    @Test
    public void testEquals4() {
        UserDto userDto = new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals5() {
        UserDto userDto = new UserDto("Jane", "Jane", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals6() {
        UserDto userDto = new UserDto("Jane", null, "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals7() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Jane", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals8() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Jane");
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testEquals9() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", null);
        assertFalse(userDto
                .equals(new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")));
    }

    @Test
    public void testHashCode() {
        assertEquals(10668934,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))
                        .hashCode());
        assertEquals(2002517195,
                (new UserDto(null, "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(243116930,
                (new UserDto("Jane", null, "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(-1009628409,
                (new UserDto("Jane", "Second Name", null, "janedoe", "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(-587222557,
                (new UserDto("Jane", "Second Name", "Doe", null, "jane.doe@example.org", "4105551212", "Role")).hashCode());
        assertEquals(-295253713,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", null, "4105551212", "Role")).hashCode());
        assertEquals(586775651,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", null, "Role")).hashCode());
        assertEquals(8115995,
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", null)).hashCode());
    }

    @Test
    public void testSetEmail() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setEmail("jane.doe@example.org");
        assertEquals("jane.doe@example.org", userDto.getEmail());
    }

    @Test
    public void testSetFirstName() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setFirstName("Jane");
        assertEquals("Jane", userDto.getFirstName());
    }

    @Test
    public void testSetId() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setId(123L);
        assertEquals(123L, userDto.getId());
    }

    @Test
    public void testSetLastName() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setLastName("Doe");
        assertEquals("Doe", userDto.getLastName());
    }

    @Test
    public void testSetPhoneNumber() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setPhoneNumber("4105551212");
        assertEquals("4105551212", userDto.getPhoneNumber());
    }

    @Test
    public void testSetRole() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setRole("Role");
        assertEquals("Role", userDto.getRole());
    }

    @Test
    public void testSetSecondName() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setSecondName("Second Name");
        assertEquals("Second Name", userDto.getSecondName());
    }

    @Test
    public void testSetUsername() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        userDto.setUsername("janedoe");
        assertEquals("janedoe", userDto.getUsername());
    }

    @Test
    public void testToString() {
        assertEquals(
                "UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane.doe"
                        + "@example.org, phoneNumber=4105551212, role=Role)",
                (new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212", "Role"))
                        .toString());
    }
}


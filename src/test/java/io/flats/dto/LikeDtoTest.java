package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class LikeDtoTest {
    @Test
    public void testConstructor() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        LikeDto actualLikeDto = new LikeDto(userDto);
        assertNull(actualLikeDto.getFlat());
        assertEquals("LikeDto(user=UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe,"
                + " email=jane.doe@example.org, phoneNumber=4105551212, role=Role, rating=0.0, dateUserFrom=null,"
                + " realtorsCommentsNomber=0), flat=null)", actualLikeDto.toString());
        UserDto expectedUser = actualLikeDto.user;
        UserDto user = actualLikeDto.getUser();
        assertSame(expectedUser, user);
        assertNull(user.getDateUserFrom());
        assertEquals("UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane"
                + ".doe@example.org, phoneNumber=4105551212, role=Role, rating=0.0, dateUserFrom=null, realtorsCommentsNomber"
                + "=0)", user.toString());
        assertEquals("janedoe", user.getUsername());
        assertEquals("Second Name", user.getSecondName());
        assertEquals("Role", user.getRole());
        assertEquals(0, user.getRealtorsCommentsNomber());
        assertEquals(0.0f, user.getRating());
        assertEquals("4105551212", user.getPhoneNumber());
        assertEquals("Doe", user.getLastName());
        assertEquals(0L, user.getId());
        assertEquals("Jane", user.getFirstName());
        assertEquals("jane.doe@example.org", user.getEmail());
        assertSame(user, userDto);
    }

    @Test
    public void testConstructor2() {
        UserDto userDto = new UserDto("Jane", "Second Name", "Doe", "janedoe", "jane.doe@example.org", "4105551212",
                "Role");
        FlatDto flatDto = new FlatDto();
        LikeDto actualLikeDto = new LikeDto(userDto, flatDto);
        FlatDto expectedFlat = actualLikeDto.flat;
        FlatDto flat = actualLikeDto.getFlat();
        assertSame(expectedFlat, flat);
        assertEquals(
                "LikeDto(user=UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe,"
                        + " email=jane.doe@example.org, phoneNumber=4105551212, role=Role, rating=0.0, dateUserFrom=null,"
                        + " realtorsCommentsNomber=0), flat=FlatDto(country=null, town=null, street=null, houseNom=null, floor=0,"
                        + " price=0.0, description=null, images=null, id=0, ownerUsername=null, ownerID=0))",
                actualLikeDto.toString());
        UserDto expectedUser = actualLikeDto.user;
        UserDto user = actualLikeDto.getUser();
        assertSame(expectedUser, user);
        assertNull(flat.getTown());
        assertEquals("UserDto(id=0, firstName=Jane, secondName=Second Name, lastName=Doe, username=janedoe, email=jane"
                + ".doe@example.org, phoneNumber=4105551212, role=Role, rating=0.0, dateUserFrom=null, realtorsCommentsNomber"
                + "=0)", user.toString());
        assertEquals("janedoe", user.getUsername());
        assertEquals("Second Name", user.getSecondName());
        assertEquals("Role", user.getRole());
        assertEquals(0, user.getRealtorsCommentsNomber());
        assertEquals(0.0f, user.getRating());
        assertEquals("4105551212", user.getPhoneNumber());
        assertEquals("Doe", user.getLastName());
        assertEquals(0L, user.getId());
        assertEquals("Jane", user.getFirstName());
        assertEquals("jane.doe@example.org", user.getEmail());
        assertNull(user.getDateUserFrom());
        assertNull(flat.getStreet());
        assertEquals(0.0f, flat.getPrice());
        assertNull(flat.getOwnerUsername());
        assertEquals(0L, flat.getOwnerID());
        assertNull(flat.getImages());
        assertEquals(0L, flat.getId());
        assertNull(flat.getHouseNom());
        assertEquals(0, flat.getFloor());
        assertNull(flat.getDescription());
        assertNull(flat.getCountry());
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=null, id=0, ownerUsername=null, ownerID=0)", flat.toString());
        assertSame(user, userDto);
        assertSame(flat, flatDto);
    }
}


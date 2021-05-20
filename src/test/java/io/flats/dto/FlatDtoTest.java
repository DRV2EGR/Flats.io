package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FlatDtoTest {
    @Test
    public void testConstructor() {
        FlatDto actualFlatDto = new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertEquals("Country", actualFlatDto.getCountry());
        assertEquals("FlatDto(country=Country, town=Oxford, street=Street, houseNom=House Nom, floor=1, price=10.0,"
                + " description=The characteristics of someone or something, images=[], id=123, ownerUsername=janedoe,"
                + " ownerID=1)", actualFlatDto.toString());
        assertEquals("Oxford", actualFlatDto.getTown());
        assertEquals("Street", actualFlatDto.getStreet());
        assertEquals(10.0f, actualFlatDto.getPrice());
        assertEquals("janedoe", actualFlatDto.getOwnerUsername());
        assertEquals(1L, actualFlatDto.getOwnerID());
        assertEquals(123L, actualFlatDto.getId());
        assertEquals("House Nom", actualFlatDto.getHouseNom());
        assertEquals(1, actualFlatDto.getFloor());
        assertEquals("The characteristics of someone or something", actualFlatDto.getDescription());
    }

    @Test
    public void testSetImageListToNew() {
        FlatDto flatDto = new FlatDto();
        flatDto.setImageListToNew();
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=[], id=0, ownerUsername=null, ownerID=0)", flatDto.toString());
    }
}


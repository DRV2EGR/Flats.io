package io.flats.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FlatDtoPayloadTest {
    @Test
    public void testConstructor() {
        ArrayList<String> stringList = new ArrayList<String>();
        FlatDtoPayload actualFlatDtoPayload = new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", stringList);
        assertEquals("Country", actualFlatDtoPayload.getCountry());
        assertEquals("FlatDtoPayload(country=Country, town=Oxford, street=Street, houseNom=House Nom, floor=1, price=10.0,"
                + " description=The characteristics of someone or something, forSale=true, forRent=true, username=janedoe,"
                + " flatsImages=[])", actualFlatDtoPayload.toString());
        assertTrue(actualFlatDtoPayload.isForSale());
        assertTrue(actualFlatDtoPayload.isForRent());
        assertEquals("janedoe", actualFlatDtoPayload.getUsername());
        assertEquals("Oxford", actualFlatDtoPayload.getTown());
        assertEquals("Street", actualFlatDtoPayload.getStreet());
        assertEquals(10.0f, actualFlatDtoPayload.getPrice());
        assertEquals("House Nom", actualFlatDtoPayload.getHouseNom());
        assertEquals(1, actualFlatDtoPayload.getFloor());
        List<String> stringList1 = actualFlatDtoPayload.flatsImages;
        List<String> flatsImages = actualFlatDtoPayload.getFlatsImages();
        assertSame(stringList1, flatsImages);
        assertTrue(flatsImages instanceof ArrayList);
        assertEquals("The characteristics of someone or something", actualFlatDtoPayload.getDescription());
        assertSame(stringList1, flatsImages);
        assertTrue(flatsImages.isEmpty());
        assertSame(flatsImages, stringList);
    }

    @Test
    public void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<String>();
        FlatDtoPayload actualFlatDtoPayload = new FlatDtoPayload("Street", true, true, stringList);
        assertNull(actualFlatDtoPayload.getCountry());
        assertEquals(
                "FlatDtoPayload(country=null, town=null, street=Street, houseNom=null, floor=0, price=0.0, description=null,"
                        + " forSale=true, forRent=true, username=null, flatsImages=[])",
                actualFlatDtoPayload.toString());
        assertTrue(actualFlatDtoPayload.isForSale());
        assertTrue(actualFlatDtoPayload.isForRent());
        assertNull(actualFlatDtoPayload.getUsername());
        assertNull(actualFlatDtoPayload.getTown());
        assertEquals("Street", actualFlatDtoPayload.getStreet());
        assertEquals(0.0f, actualFlatDtoPayload.getPrice());
        assertNull(actualFlatDtoPayload.getHouseNom());
        assertEquals(0, actualFlatDtoPayload.getFloor());
        List<String> stringList1 = actualFlatDtoPayload.flatsImages;
        List<String> flatsImages = actualFlatDtoPayload.getFlatsImages();
        assertSame(stringList1, flatsImages);
        assertTrue(flatsImages instanceof ArrayList);
        assertNull(actualFlatDtoPayload.getDescription());
        assertSame(stringList1, flatsImages);
        assertTrue(flatsImages.isEmpty());
        assertSame(flatsImages, stringList);
    }
}


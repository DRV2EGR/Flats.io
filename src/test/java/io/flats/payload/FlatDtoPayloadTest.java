package io.flats.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlatDtoPayloadTest {
    @Test
    public void testCanEqual() {
        assertFalse((new FlatDtoPayload()).canEqual("Other"));
        assertFalse((new FlatDtoPayload()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertTrue(flatDtoPayload.canEqual(new FlatDtoPayload()));
    }

    @Test
    public void testCanEqual3() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertTrue(flatDtoPayload.canEqual(new FlatDtoPayload()));
    }

    @Test
    public void testEquals() {
        assertFalse((new FlatDtoPayload()).equals("42"));
        assertFalse((new FlatDtoPayload()).equals("42"));
    }

    @Test
    public void testEquals10() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setTown("Oxford");
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testEquals11() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setDescription("The characteristics of someone or something");
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testEquals12() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();

        FlatDtoPayload flatDtoPayload1 = new FlatDtoPayload();
        flatDtoPayload1.setUsername("janedoe");
        assertFalse(flatDtoPayload.equals(flatDtoPayload1));
    }

    @Test
    public void testEquals13() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();

        FlatDtoPayload flatDtoPayload1 = new FlatDtoPayload();
        flatDtoPayload1.setTown("Oxford");
        assertFalse(flatDtoPayload.equals(flatDtoPayload1));
    }

    @Test
    public void testEquals14() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();

        FlatDtoPayload flatDtoPayload1 = new FlatDtoPayload();
        flatDtoPayload1.setDescription("The characteristics of someone or something");
        assertFalse(flatDtoPayload.equals(flatDtoPayload1));
    }

    @Test
    public void testEquals15() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload(null, true, true, new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals16() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("io.flats.payload.FlatDtoPayload", true, true,
                new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals17() {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("Street");
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Street", true, true, stringList);
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals18() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload(null, "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals19() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Oxford", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertTrue(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testEquals20() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Country", "Oxford", "Street", "Country", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals21() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Country", "Oxford", "Street", null, 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals22() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertTrue(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testEquals23() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals24() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals25() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Street", true, true, new ArrayList<String>());
        assertTrue(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals26() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", false, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals27() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertTrue(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals28() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 0, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals29() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setUsername("janedoe");
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testEquals3() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals30() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setTown("Oxford");
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testEquals31() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setDescription("The characteristics of someone or something");
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testEquals32() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();

        FlatDtoPayload flatDtoPayload1 = new FlatDtoPayload();
        flatDtoPayload1.setUsername("janedoe");
        assertFalse(flatDtoPayload.equals(flatDtoPayload1));
    }

    @Test
    public void testEquals33() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();

        FlatDtoPayload flatDtoPayload1 = new FlatDtoPayload();
        flatDtoPayload1.setTown("Oxford");
        assertFalse(flatDtoPayload.equals(flatDtoPayload1));
    }

    @Test
    public void testEquals34() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();

        FlatDtoPayload flatDtoPayload1 = new FlatDtoPayload();
        flatDtoPayload1.setDescription("The characteristics of someone or something");
        assertFalse(flatDtoPayload.equals(flatDtoPayload1));
    }

    @Test
    public void testEquals35() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload(null, true, true, new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals36() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("io.flats.payload.FlatDtoPayload", true, true,
                new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals37() {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("Street");
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Street", true, true, stringList);
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals38() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload(null, "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals39() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Oxford", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals4() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals40() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Country", "Oxford", "Street", "Country", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals41() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Country", "Oxford", "Street", null, 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals5() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Street", true, true, new ArrayList<String>());
        assertTrue(flatDtoPayload.equals(new FlatDtoPayload("Street", true, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals6() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Street", false, true, new ArrayList<String>())));
    }

    @Test
    public void testEquals7() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>());
        assertTrue(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals8() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 0, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())));
    }

    @Test
    public void testEquals9() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setUsername("janedoe");
        assertFalse(flatDtoPayload.equals(new FlatDtoPayload()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-401152842, (new FlatDtoPayload()).hashCode());
        assertEquals(1962064092, (new FlatDtoPayload("Street", true, true, new ArrayList<String>())).hashCode());
        assertEquals(1160000747, (new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())).hashCode());
        assertEquals(-401152842, (new FlatDtoPayload()).hashCode());
        assertEquals(1962064092, (new FlatDtoPayload("Street", true, true, new ArrayList<String>())).hashCode());
        assertEquals(1160000747, (new FlatDtoPayload("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", true, true, "janedoe", new ArrayList<String>())).hashCode());
    }

    @Test
    public void testSetCountry() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setCountry("Country");
        assertEquals("Country", flatDtoPayload.getCountry());
    }

    @Test
    public void testSetCountry2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setCountry("Country");
        assertEquals("Country", flatDtoPayload.getCountry());
    }

    @Test
    public void testSetDescription() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setDescription("The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", flatDtoPayload.getDescription());
    }

    @Test
    public void testSetDescription2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setDescription("The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", flatDtoPayload.getDescription());
    }

    @Test
    public void testSetFlatsImages() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        assertEquals(
                "FlatDtoPayload(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                        + " forSale=false, forRent=false, username=null, flatsImages=[])",
                flatDtoPayload.toString());
    }

    @Test
    public void testSetFlatsImages2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFlatsImages(new ArrayList<String>());
        assertEquals(
                "FlatDtoPayload(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                        + " forSale=false, forRent=false, username=null, flatsImages=[])",
                flatDtoPayload.toString());
    }

    @Test
    public void testSetFloor() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFloor(1);
        assertEquals(1, flatDtoPayload.getFloor());
    }

    @Test
    public void testSetFloor2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setFloor(1);
        assertEquals(1, flatDtoPayload.getFloor());
    }

    @Test
    public void testSetForRent() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setForRent(true);
        assertTrue(flatDtoPayload.isForRent());
    }

    @Test
    public void testSetForRent2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setForRent(true);
        assertTrue(flatDtoPayload.isForRent());
    }

    @Test
    public void testSetForSale() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setForSale(true);
        assertTrue(flatDtoPayload.isForSale());
    }

    @Test
    public void testSetForSale2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setForSale(true);
        assertTrue(flatDtoPayload.isForSale());
    }

    @Test
    public void testSetHouseNom() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setHouseNom("House Nom");
        assertEquals("House Nom", flatDtoPayload.getHouseNom());
    }

    @Test
    public void testSetHouseNom2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setHouseNom("House Nom");
        assertEquals("House Nom", flatDtoPayload.getHouseNom());
    }

    @Test
    public void testSetPrice() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setPrice(10.0f);
        assertEquals(10.0f, flatDtoPayload.getPrice());
    }

    @Test
    public void testSetPrice2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setPrice(10.0f);
        assertEquals(10.0f, flatDtoPayload.getPrice());
    }

    @Test
    public void testSetStreet() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setStreet("Street");
        assertEquals("Street", flatDtoPayload.getStreet());
    }

    @Test
    public void testSetStreet2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setStreet("Street");
        assertEquals("Street", flatDtoPayload.getStreet());
    }

    @Test
    public void testSetTown() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setTown("Oxford");
        assertEquals("Oxford", flatDtoPayload.getTown());
    }

    @Test
    public void testSetTown2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setTown("Oxford");
        assertEquals("Oxford", flatDtoPayload.getTown());
    }

    @Test
    public void testSetUsername() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setUsername("janedoe");
        assertEquals("janedoe", flatDtoPayload.getUsername());
    }

    @Test
    public void testSetUsername2() {
        FlatDtoPayload flatDtoPayload = new FlatDtoPayload();
        flatDtoPayload.setUsername("janedoe");
        assertEquals("janedoe", flatDtoPayload.getUsername());
    }

    @Test
    public void testToString() {
        assertEquals(
                "FlatDtoPayload(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                        + " forSale=false, forRent=false, username=null, flatsImages=null)",
                (new FlatDtoPayload()).toString());
        assertEquals(
                "FlatDtoPayload(country=null, town=null, street=Street, houseNom=null, floor=0, price=0.0, description=null,"
                        + " forSale=true, forRent=true, username=null, flatsImages=[])",
                (new FlatDtoPayload("Street", true, true, new ArrayList<String>())).toString());
        assertEquals(
                "FlatDtoPayload(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                        + " forSale=false, forRent=false, username=null, flatsImages=null)",
                (new FlatDtoPayload()).toString());
        assertEquals(
                "FlatDtoPayload(country=null, town=null, street=Street, houseNom=null, floor=0, price=0.0, description=null,"
                        + " forSale=true, forRent=true, username=null, flatsImages=[])",
                (new FlatDtoPayload("Street", true, true, new ArrayList<String>())).toString());
    }
}


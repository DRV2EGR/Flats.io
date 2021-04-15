package io.flats.dto;

import java.util.ArrayList;
import java.util.List;

import io.flats.JWT_AUTH.payload.UserDtoPayload;
import io.flats.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlatDtoTest {

    @Test
    public void testCanEqual() {
        assertFalse((new FlatDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        FlatDto flatDto = new FlatDto();
        assertTrue(flatDto.canEqual(new FlatDto()));
    }

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
    public void testConstructor2() {
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
    public void testConstrictorAllArgs() {
        FlatDto fd = new FlatDto("S1Cr1T", "S1Cr1T", "S1Cr1T",
                "S1Cr1T", 12, 12F,
                "S1Cr1T", List.of("S1Cr1T", "S1Cr1T"), 12L,
                "S1Cr1T", 12L);

        assertThat(fd.getCountry()).isEqualTo("S1Cr1T");
        assertThat(fd.getTown()).isEqualTo("S1Cr1T");
        assertThat(fd.getStreet()).isEqualTo("S1Cr1T");
        assertThat(fd.getHouseNom()).isEqualTo("S1Cr1T");
        assertThat(fd.getFloor()).isEqualTo(12);
        assertThat(fd.getPrice()).isEqualTo(12F);
        assertThat(fd.getDescription()).isEqualTo("S1Cr1T");
        assertThat(fd.getImages().size()).isEqualTo(2);
        assertThat(fd.getId()).isEqualTo(12L);
        assertThat(fd.getOwnerUsername()).isEqualTo("S1Cr1T");
        assertThat(fd.getOwnerID()).isEqualTo(12L);
    }

    @Test
    public void testEquals() {
        assertFalse((new FlatDto()).equals("42"));
    }

    @Test
    public void testEquals10() {
        FlatDto flatDto = new FlatDto();

        FlatDto flatDto1 = new FlatDto();
        flatDto1.setTown("Oxford");
        assertFalse(flatDto.equals(flatDto1));
    }

    @Test
    public void testEquals11() {
        FlatDto flatDto = new FlatDto();

        FlatDto flatDto1 = new FlatDto();
        flatDto1.setOwnerUsername("janedoe");
        assertFalse(flatDto.equals(flatDto1));
    }

    @Test
    public void testEquals12() {
        FlatDto flatDto = new FlatDto();

        FlatDto flatDto1 = new FlatDto();
        flatDto1.setDescription("The characteristics of someone or something");
        assertFalse(flatDto.equals(flatDto1));
    }

    @Test
    public void testEquals13() {
        FlatDto flatDto = new FlatDto(null, "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals14() {
        FlatDto flatDto = new FlatDto("Oxford", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals15() {
        FlatDto flatDto = new FlatDto("Country", "Oxford", "Country", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals16() {
        FlatDto flatDto = new FlatDto("Country", "Oxford", null, "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals17() {
        FlatDto flatDto = new FlatDto("Country", "Oxford", "Street", "Country", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals18() {
        FlatDto flatDto = new FlatDto("Country", "Oxford", "Street", null, 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals19() {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("Country");
        FlatDto flatDto = new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", stringList, 123L, "janedoe", 1L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

//    @Test
//    public void testEquals2() {
//        FlatDto flatDto = new FlatDto();
//        assertTrue(flatDto.equals(new FlatDto()));
//    }

    @Test
    public void testEquals20() {
        FlatDto flatDto = new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 0L);
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals3() {
        FlatDto flatDto = new FlatDto();
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals4() {
        FlatDto flatDto = new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L);
        assertTrue(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals5() {
        FlatDto flatDto = new FlatDto();
        assertFalse(flatDto.equals(new FlatDto("Country", "Oxford", "Street", "House Nom", 0, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)));
    }

    @Test
    public void testEquals6() {
        FlatDto flatDto = new FlatDto();
        flatDto.setId(123L);
        assertFalse(flatDto.equals(new FlatDto()));
    }

    @Test
    public void testEquals7() {
        FlatDto flatDto = new FlatDto();
        flatDto.setTown("Oxford");
        assertFalse(flatDto.equals(new FlatDto()));
    }

    @Test
    public void testEquals8() {
        FlatDto flatDto = new FlatDto();
        flatDto.setOwnerUsername("janedoe");
        assertFalse(flatDto.equals(new FlatDto()));
    }

    @Test
    public void testEquals9() {
        FlatDto flatDto = new FlatDto();
        flatDto.setDescription("The characteristics of someone or something");
        assertFalse(flatDto.equals(new FlatDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(529239746, (new FlatDto()).hashCode());
        assertEquals(-1805968433, (new FlatDto("Country", "Oxford", "Street", "House Nom", 1, 10.0f,
                "The characteristics of someone or something", new ArrayList<String>(), 123L, "janedoe", 1L)).hashCode());
    }

    @Test
    public void testSetCountry() {
        FlatDto flatDto = new FlatDto();
        flatDto.setCountry("Country");
        assertEquals("Country", flatDto.getCountry());
    }

    @Test
    public void testSetDescription() {
        FlatDto flatDto = new FlatDto();
        flatDto.setDescription("The characteristics of someone or something");
        assertEquals("The characteristics of someone or something", flatDto.getDescription());
    }

    @Test
    public void testSetFloor() {
        FlatDto flatDto = new FlatDto();
        flatDto.setFloor(1);
        assertEquals(1, flatDto.getFloor());
    }

    @Test
    public void testSetHouseNom() {
        FlatDto flatDto = new FlatDto();
        flatDto.setHouseNom("House Nom");
        assertEquals("House Nom", flatDto.getHouseNom());
    }

    @Test
    public void testSetId() {
        FlatDto flatDto = new FlatDto();
        flatDto.setId(123L);
        assertEquals(123L, flatDto.getId());
    }

    @Test
    public void testSetImageListToNew() {
        FlatDto fd = new FlatDto();
        fd.setImageListToNew();

        assertThat(fd.getImages()).isNotNull();
    }

    @Test
    public void testSetImageListToNew2() {
        FlatDto flatDto = new FlatDto();
        flatDto.setImageListToNew();
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=[], id=0, ownerUsername=null, ownerID=0)", flatDto.toString());
    }

    @Test
    public void testSetImageListToNew3() {
        FlatDto flatDto = new FlatDto();
        flatDto.setImageListToNew();
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=[], id=0, ownerUsername=null, ownerID=0)", flatDto.toString());
    }

    @Test
    public void testSetImages() {
        FlatDto flatDto = new FlatDto();
        flatDto.setImages(new ArrayList<String>());
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=[], id=0, ownerUsername=null, ownerID=0)", flatDto.toString());
    }

    @Test
    public void testSetOwnerID() {
        FlatDto flatDto = new FlatDto();
        flatDto.setOwnerID(1L);
        assertEquals(1L, flatDto.getOwnerID());
    }

    @Test
    public void testSetOwnerUsername() {
        FlatDto flatDto = new FlatDto();
        flatDto.setOwnerUsername("janedoe");
        assertEquals("janedoe", flatDto.getOwnerUsername());
    }

    @Test
    public void testSetPrice() {
        FlatDto flatDto = new FlatDto();
        flatDto.setPrice(10.0f);
        assertEquals(10.0f, flatDto.getPrice());
    }

    @Test
    public void testSetStreet() {
        FlatDto flatDto = new FlatDto();
        flatDto.setStreet("Street");
        assertEquals("Street", flatDto.getStreet());
    }

    @Test
    public void testSetTown() {
        FlatDto flatDto = new FlatDto();
        flatDto.setTown("Oxford");
        assertEquals("Oxford", flatDto.getTown());
    }

    @Test
    public void testToString() {
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=null, id=0, ownerUsername=null, ownerID=0)", (new FlatDto()).toString());
    }
}

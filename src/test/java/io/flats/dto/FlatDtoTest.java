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

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlatDtoTest {

    @org.junit.jupiter.api.Test
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
    public void testSetImageListToNew() {
        FlatDto fd = new FlatDto();
        fd.setImageListToNew();

        assertThat(fd.getImages()).isNotNull();
    }

    @org.junit.jupiter.api.Test
    public void testSetImageListToNew2() {
        FlatDto flatDto = new FlatDto();
        flatDto.setImageListToNew();
        assertEquals("FlatDto(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " images=[], id=0, ownerUsername=null, ownerID=0)", flatDto.toString());
    }
}

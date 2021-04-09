package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlatTest {
    @Test
    public void testConstructor() {
        Flat actualFlat = new Flat(123L, new ArrayList<FlatsImages>());
        assertEquals("Flat(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " orderType=null, owner=null, flatsImages=[])", actualFlat.toString());
        assertEquals(123L, actualFlat.getId());
    }
}


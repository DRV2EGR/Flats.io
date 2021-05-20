package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class FlatTest {
    @Test
    public void testConstructor() {
        assertEquals(123L, (new Flat(123L)).getId());
    }

    @Test
    public void testConstructor2() {
        Flat actualFlat = new Flat(123L, new ArrayList<FlatsImages>());
        assertEquals("Flat(country=null, town=null, street=null, houseNom=null, floor=0, price=0.0, description=null,"
                + " orderType=null, owner=null, flatsImages=[], flatsLikes=null)", actualFlat.toString());
        assertEquals(123L, actualFlat.getId());
    }
}


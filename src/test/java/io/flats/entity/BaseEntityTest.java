package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BaseEntityTest {
    @Test
    public void testSetId() {
        Flat flat = new Flat(123L);
        flat.setId(123L);
        assertEquals(123L, flat.getId());
    }
}


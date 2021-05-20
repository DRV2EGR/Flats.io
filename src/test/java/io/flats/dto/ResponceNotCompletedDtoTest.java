package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResponceNotCompletedDtoTest {
    @Test
    public void testConstructor() {
        assertEquals("Not completed.", (new ResponceNotCompletedDto()).getResponse());
    }
}


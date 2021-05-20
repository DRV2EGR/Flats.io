package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResponceCompletedDtoTest {
    @Test
    public void testConstructor() {
        assertEquals("OK", (new ResponceCompletedDto()).getResponse());
    }
}


package io.flats.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LikeDtoPayloadTest {
    @Test
    public void testConstructor() {
        assertEquals(1L, (new LikeDtoPayload(1L)).getId_to());
    }
}


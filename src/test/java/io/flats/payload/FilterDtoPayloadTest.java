package io.flats.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FilterDtoPayloadTest {
    @Test
    public void testConstructor() {
        FilterDtoPayload actualFilterDtoPayload = new FilterDtoPayload(1, "Street Name", 3);
        assertEquals(1, actualFilterDtoPayload.getFloorNomber());
        assertEquals("Street Name", actualFilterDtoPayload.getStreetName());
        assertEquals(3, actualFilterDtoPayload.getRoomsCount());
    }
}


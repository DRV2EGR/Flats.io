package io.flats.payload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FilterDtoPayloadTest {
    @Test
    public void testCanEqual() {
        assertFalse((new FilterDtoPayload(1, "Street Name", 3)).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "Street Name", 3);
        assertTrue(filterDtoPayload.canEqual(new FilterDtoPayload(1, "Street Name", 3)));
    }

    @Test
    public void testEquals() {
        assertFalse((new FilterDtoPayload(1, "Street Name", 3)).equals("42"));
    }

    @Test
    public void testEquals2() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "Street Name", 3);
        assertTrue(filterDtoPayload.equals(new FilterDtoPayload(1, "Street Name", 3)));
    }

    @Test
    public void testEquals3() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "Street Name", 3);
        assertFalse(filterDtoPayload.equals(new FilterDtoPayload()));
    }

    @Test
    public void testEquals4() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, null, 3);
        assertFalse(filterDtoPayload.equals(new FilterDtoPayload(1, "Street Name", 3)));
    }

    @Test
    public void testEquals5() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "io.flats.payload.FilterDtoPayload", 3);
        assertFalse(filterDtoPayload.equals(new FilterDtoPayload(1, "Street Name", 3)));
    }

    @Test
    public void testEquals6() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "Street Name", 0);
        assertFalse(filterDtoPayload.equals(new FilterDtoPayload(1, "Street Name", 3)));
    }

    @Test
    public void testEquals7() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload();
        assertTrue(filterDtoPayload.equals(new FilterDtoPayload()));
    }

    @Test
    public void testHashCode() {
        assertEquals(-1603276523, (new FilterDtoPayload(1, "Street Name", 3)).hashCode());
        assertEquals(209080, (new FilterDtoPayload(1, null, 3)).hashCode());
    }

    @Test
    public void testSetFloorNomber() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "Street Name", 3);
        filterDtoPayload.setFloorNomber(1);
        assertEquals(1, filterDtoPayload.getFloorNomber());
    }

    @Test
    public void testSetRoomsCount() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "Street Name", 3);
        filterDtoPayload.setRoomsCount(3);
        assertEquals(3, filterDtoPayload.getRoomsCount());
    }

    @Test
    public void testSetStreetName() {
        FilterDtoPayload filterDtoPayload = new FilterDtoPayload(1, "Street Name", 3);
        filterDtoPayload.setStreetName("Street Name");
        assertEquals("Street Name", filterDtoPayload.getStreetName());
    }

    @Test
    public void testToString() {
        assertEquals("FilterDtoPayload(floorNomber=1, streetName=Street Name, roomsCount=3)",
                (new FilterDtoPayload(1, "Street Name", 3)).toString());
    }
}


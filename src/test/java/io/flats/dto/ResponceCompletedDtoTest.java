package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResponceCompletedDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new ResponceCompletedDto()).canEqual("Other"));
        assertFalse((new ResponceCompletedDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        assertTrue(responceCompletedDto.canEqual(new ResponceCompletedDto()));
    }

    @Test
    public void testCanEqual3() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        assertTrue(responceCompletedDto.canEqual(new ResponceCompletedDto()));
    }

    @Test
    public void testEquals() {
        assertFalse((new ResponceCompletedDto()).equals("42"));
        assertFalse((new ResponceCompletedDto()).equals("42"));
    }

    @Test
    public void testEquals2() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        assertTrue(responceCompletedDto.equals(new ResponceCompletedDto()));
    }

    @Test
    public void testEquals3() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        responceCompletedDto.setResponse("Response");
        assertFalse(responceCompletedDto.equals(new ResponceCompletedDto()));
    }

    @Test
    public void testEquals4() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        assertTrue(responceCompletedDto.equals(new ResponceCompletedDto()));
    }

    @Test
    public void testEquals5() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        responceCompletedDto.setResponse("Response");
        assertFalse(responceCompletedDto.equals(new ResponceCompletedDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(2583, (new ResponceCompletedDto()).hashCode());
        assertEquals(2583, (new ResponceCompletedDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        responceCompletedDto.setResponse(null);
        assertEquals(102, responceCompletedDto.hashCode());
    }

    @Test
    public void testHashCode3() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        responceCompletedDto.setResponse(null);
        assertEquals(102, responceCompletedDto.hashCode());
    }

    @Test
    public void testSetResponse() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        responceCompletedDto.setResponse("Response");
        assertEquals("Response", responceCompletedDto.getResponse());
    }

    @Test
    public void testSetResponse2() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        responceCompletedDto.setResponse("Response");
        assertEquals("Response", responceCompletedDto.getResponse());
    }

    @Test
    public void testToString() {
        assertEquals("ResponceCompletedDto(response=OK)", (new ResponceCompletedDto()).toString());
        assertEquals("ResponceCompletedDto(response=OK)", (new ResponceCompletedDto()).toString());
    }
}


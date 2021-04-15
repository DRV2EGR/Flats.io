package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResponceNotCompletedDtoTest {
    @Test
    public void testCanEqual() {
        assertFalse((new ResponceNotCompletedDto()).canEqual("Other"));
        assertFalse((new ResponceNotCompletedDto()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        assertTrue(responceNotCompletedDto.canEqual(new ResponceNotCompletedDto()));
    }

    @Test
    public void testCanEqual3() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        assertTrue(responceNotCompletedDto.canEqual(new ResponceNotCompletedDto()));
    }

    @Test
    public void testEquals() {
        assertFalse((new ResponceNotCompletedDto()).equals("42"));
        assertFalse((new ResponceNotCompletedDto()).equals("42"));
    }

    @Test
    public void testEquals2() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        assertTrue(responceNotCompletedDto.equals(new ResponceNotCompletedDto()));
    }

    @Test
    public void testEquals3() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        responceNotCompletedDto.setResponse("Response");
        assertFalse(responceNotCompletedDto.equals(new ResponceNotCompletedDto()));
    }

    @Test
    public void testEquals4() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        assertTrue(responceNotCompletedDto.equals(new ResponceNotCompletedDto()));
    }

    @Test
    public void testEquals5() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        responceNotCompletedDto.setResponse("Response");
        assertFalse(responceNotCompletedDto.equals(new ResponceNotCompletedDto()));
    }

    @Test
    public void testHashCode() {
        assertEquals(892754699, (new ResponceNotCompletedDto()).hashCode());
        assertEquals(892754699, (new ResponceNotCompletedDto()).hashCode());
    }

    @Test
    public void testHashCode2() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        responceNotCompletedDto.setResponse(null);
        assertEquals(102, responceNotCompletedDto.hashCode());
    }

    @Test
    public void testHashCode3() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        responceNotCompletedDto.setResponse(null);
        assertEquals(102, responceNotCompletedDto.hashCode());
    }

    @Test
    public void testSetResponse() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        responceNotCompletedDto.setResponse("Response");
        assertEquals("Response", responceNotCompletedDto.getResponse());
    }

    @Test
    public void testSetResponse2() {
        ResponceNotCompletedDto responceNotCompletedDto = new ResponceNotCompletedDto();
        responceNotCompletedDto.setResponse("Response");
        assertEquals("Response", responceNotCompletedDto.getResponse());
    }

    @Test
    public void testToString() {
        assertEquals("ResponceNotCompletedDto(response=Not completed.)", (new ResponceNotCompletedDto()).toString());
        assertEquals("ResponceNotCompletedDto(response=Not completed.)", (new ResponceNotCompletedDto()).toString());
    }
}


package io.flats.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BasicResponceTest {
    @Test
    public void testSetResponse() {
        ResponceCompletedDto responceCompletedDto = new ResponceCompletedDto();
        responceCompletedDto.setResponse("Response");
        assertEquals("Response", responceCompletedDto.getResponse());
    }
}


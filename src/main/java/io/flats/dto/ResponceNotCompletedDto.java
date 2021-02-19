package io.flats.dto;

import lombok.Data;

@Data
public class ResponceNotCompletedDto extends BasicResponce{
    protected String response;

    public ResponceNotCompletedDto() {
        this.response = "Not completed.";
    }
}

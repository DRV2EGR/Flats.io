package io.flats.dto;

import lombok.Data;

@Data
public class ResponceCompletedDto extends BasicResponce {
    protected String response;

    public ResponceCompletedDto() {
        this.response = "OK.";
    }
}

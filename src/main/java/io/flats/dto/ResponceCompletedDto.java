package io.flats.dto;

import lombok.Data;

/**
 * The type Responce completed dto.
 */
@Data
public class ResponceCompletedDto extends BasicResponce {
    /**
     * The Response.
     */
    protected String response;

    /**
     * Instantiates a new Responce completed dto.
     */
    public ResponceCompletedDto() {
        this.response = "OK";
    }
}

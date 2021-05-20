package io.flats.dto;

import lombok.Data;

/**
 * The type Responce not completed dto.
 */
@Data
public class ResponceNotCompletedDto extends BasicResponce{
    /**
     * The Response.
     */
    protected String response;

    /**
     * Instantiates a new Responce not completed dto.
     */
    public ResponceNotCompletedDto() {
        this.response = "Not completed.";
    }
}

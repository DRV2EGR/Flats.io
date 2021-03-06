package io.flats.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Basic responce.
 */
@Data
@NoArgsConstructor
public abstract class BasicResponce {
    /**
     * The Response.
     */
    protected String response;
}

package io.flats.JWT_AUTH.dto;

import lombok.Data;

/**
 * The type Authentication request dto.
 */
@Data
public class AuthenticationRequestDto {
    private String email;
    private String password;
}

package io.flats.JWT_AUTH.config.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class JwtInvalidAccessTokenException extends BadRequestException {
    private static final long serialVersionUID = 1L;
}

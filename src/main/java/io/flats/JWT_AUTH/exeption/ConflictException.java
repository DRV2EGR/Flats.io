package io.flats.JWT_AUTH.exeption;

import io.flats.exception.ApiClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends ApiClientException {
    private static final long serialVersionUID = 1L;
}

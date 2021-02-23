package io.flats.JWT_AUTH.config.exeption;

import io.flats.exception.ApiClientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiClientException {
    private static final long serialVersionUID = 1L;
}
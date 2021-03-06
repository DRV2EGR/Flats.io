package io.flats.controller;

import io.flats.dto.BasicResponce;
import io.flats.dto.ResponceCompletedDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The type Restfull.
 */
@Controller
@RequestMapping("/api/check_stability")
public class restfull {
    /**
     * The Response.
     */
    protected String response;

    /**
     * Return pong response entity.
     *
     * @return the response entity
     */
    @RequestMapping("/ping")
    @ResponseBody
    /**
     * Метод returnPong для проверки работоспособности сервиса.
     */
    public ResponseEntity<BasicResponce> returnPong() {
        return ResponseEntity.ok(new ResponceCompletedDto());
    }

}

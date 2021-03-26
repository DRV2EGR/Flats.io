package io.flats.controller;

import io.flats.dto.BasicResponce;
import io.flats.entity.Flat;
import io.flats.payload.FlatDtoPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FlatController {

    public ResponseEntity<BasicResponce> addFlat(@RequestBody FlatDtoPayload newFlat) {
        //TODO: addFlat

        return null;
    }

    public ResponseEntity<BasicResponce> deleteFlat(@RequestBody Long id) {
        //TODO: deleteFlat

        return null;
    }

    public ResponseEntity<BasicResponce> getFlat(@RequestBody Long id) {
        //TODO: getFlat

        return null;
    }
}

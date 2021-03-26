package io.flats.controller;

import io.flats.JWT_AUTH.service.UserService;
import io.flats.dto.BasicResponce;
import io.flats.dto.ResponceCompletedDto;
import io.flats.entity.Flat;
import io.flats.payload.FlatDtoPayload;
import io.flats.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flats") //TODO: изменить на /api/private/flats и в остальных мапингах тоже.
public class FlatController {
    @Autowired
    FlatService flatService;

    @RequestMapping(value = "/add_flat", method = RequestMethod.POST)
    public ResponseEntity<BasicResponce> addFlat(@RequestBody FlatDtoPayload newFlat) {
        //TODO: addFlat
        if (newFlat.isForSale() && !newFlat.isForRent()) {
            flatService.addSaleFlat(newFlat);
        } else if (!newFlat.isForSale() && newFlat.isForRent()) {
            flatService.addRentFlat(newFlat);
        } else {
            throw new IllegalArgumentException();
        }

        return ResponseEntity.ok(new ResponceCompletedDto());
    }

    @RequestMapping(value = "/delete_flat", method = RequestMethod.DELETE)
    public ResponseEntity<BasicResponce> deleteFlat(@RequestBody Long id) {
        //TODO: deleteFlat

        return null;
    }

    @RequestMapping(value = "/get_flat", method = RequestMethod.GET)
    public ResponseEntity<BasicResponce> getFlat(@RequestBody Long id) {
        //TODO: getFlat

        return null;
    }
}

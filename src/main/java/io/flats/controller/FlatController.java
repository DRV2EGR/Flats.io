package io.flats.controller;

import io.flats.JWT_AUTH.service.UserService;
import io.flats.dto.BasicResponce;
import io.flats.dto.FlatDto;
import io.flats.dto.ResponceCompletedDto;
import io.flats.entity.Flat;
import io.flats.payload.FlatDtoPayload;
import io.flats.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flats") //TODO: изменить на /api/private/flats и в остальных мапингах тоже.
public class FlatController {
    @Autowired
    FlatService flatService;

    @RequestMapping(value = "/add_flat", method = RequestMethod.POST)
    public ResponseEntity<BasicResponce> addFlat(@RequestBody FlatDtoPayload newFlat) {
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
    public ResponseEntity<FlatDto> getFlat(@RequestParam Long id) {
        Flat flat = flatService.findFlatById(id);

        FlatDto fdto = new FlatDto();
        fdto.setCountry(flat.getCountry());
        fdto.setTown(flat.getTown());
        fdto.setStreet(flat.getStreet());
        fdto.setHouseNom(flat.getHouseNom());
        fdto.setFloor(flat.getFloor());

        fdto.setDescription(flat.getDescription());
        fdto.setPrice(flat.getPrice());

        return ResponseEntity.ok(fdto);
    }
}
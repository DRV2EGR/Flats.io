package io.flats.controller;

import java.util.*;

import io.flats.JWT_AUTH.jwt.JwtUser;
import io.flats.JWT_AUTH.jwt.JwtUserDetailsService;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.dto.*;
import io.flats.entity.Flat;
import io.flats.entity.FlatsImages;
import io.flats.entity.Likes;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.payload.FlatDtoPayload;
import io.flats.repository.LikesRepository;
import io.flats.service.FlatService;
import io.flats.service.LikeAndCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flats") //TODO: изменить на /api/private/flats и в остальных мапингах тоже.
public class FlatController {
    @Autowired
    FlatService flatService;

    @Autowired
    UserService userService;

    @Autowired
    LikeAndCommentService likeAndCommentService;

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

    @RequestMapping(value = "/delete_flat",
            method = RequestMethod.GET
    )
    public ResponseEntity<BasicResponce> deleteFlat(@RequestParam Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = userService.findByUsername(currentPrincipalName).orElseThrow(
                    () -> {throw new UserNotFoundExeption();
                });

        boolean flag = false;
        if (currentUser.getRole().getName().equals("ROLE_ADMIN") || flatService.findFlatById(id).getOwner().getId() == currentUser.getId()) {
            flag = flatService.deleteFlatById(id);
        }

        System.out.println(new ResponceCompletedDto());
        return (flag) ? ResponseEntity.ok(new ResponceCompletedDto()) : ResponseEntity.ok(new ResponceNotCompletedDto());
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
        fdto.setId(flat.getId());

        fdto.setDescription(flat.getDescription());
        fdto.setPrice(flat.getPrice());

        fdto.setOwnerUsername(flat.getOwner().getUsername());
        fdto.setOwnerID(flat.getOwner().getId());

        fdto.setImageListToNew();
        for (FlatsImages image: flat.getFlatsImages()) {
            fdto.getImages().add(image.getImgUrl());
        }

        return ResponseEntity.ok(fdto);
    }

    @RequestMapping(value = "/get_likes_to_flat_by_id", method = RequestMethod.GET)
    public ResponseEntity<List<LikeDto>> getLikesToFlatById(@RequestParam long id) {
        List<Likes> likes = likeAndCommentService.getLikesOfFlatById(id);

        List<LikeDto> likesDto = new ArrayList();
        for (Likes like:likes) {
            LikeDto ldto = new LikeDto();
//            ldto.setFlat(
//                    flatService.convertFlatToFlatDto(like.getFlat())
//            );
            ldto.setUser(
                    userService.convertUserToUserDto(like.getUser())
            );
            likesDto.add(ldto);
        }

        return ResponseEntity.ok(likesDto);
    }
}

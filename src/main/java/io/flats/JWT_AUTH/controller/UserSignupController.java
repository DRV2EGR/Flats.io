package io.flats.JWT_AUTH.controller;


import io.flats.JWT_AUTH.dto.UserDto;
import io.flats.JWT_AUTH.exeption.ConflictException;
import io.flats.JWT_AUTH.payload.UserDtoPayload;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type User signup controller.
 */
@Controller
@RequestMapping("/api/signup")
public class UserSignupController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * Signup new seller response entity.
     *
     * @param sellerDto the seller dto
     * @return the response entity
     */
    @PostMapping("/seller")
    public ResponseEntity<User> signupNewSeller(@RequestBody UserDtoPayload sellerDto) {
        if (userService.findByUsername(sellerDto.getUsername()).isPresent())
            throw new ConflictException();

        User registeredUser = userService.registerNewSailor(sellerDto);
        return ResponseEntity.ok(registeredUser);
    }

    /**
     * Signup new realtor response entity.
     *
     * @param realtorDto the realtor dto
     * @return the response entity
     */
    @PostMapping("/realtor")
    public ResponseEntity<User> signupNewRealtor(@RequestBody UserDtoPayload realtorDto) {
        if (userService.findByUsername(realtorDto.getUsername()).isPresent())
            throw new ConflictException();

        User registeredUser = userService.registerNewRealtor(realtorDto);
        return ResponseEntity.ok(registeredUser);
    }

    //  TODO:
//    @PostMapping("/admin")

}

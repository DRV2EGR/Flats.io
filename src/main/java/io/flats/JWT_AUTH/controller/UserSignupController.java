package io.flats.JWT_AUTH.controller;

import io.flats.JWT_AUTH.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/signup")
public class UserSignupController {
    @Autowired
    UserService userService;

//    @PostMapping("/initiator")
//    public ResponseEntity<UserPayloadDto> signupNewInitiator(@RequestBody InitiatorDto initiatorDto) {
//        if (userService.findByUsername(initiatorDto.getUsername()).isPresent())
//            throw new ConflictException();
//
//        Initiator registeredUser = userService.registerNewInitiator(initiatorDto);
//        return ResponseEntity.ok(UserPayloadDtoFactory.createUserDto(registeredUser));
//    }
//
//    @PostMapping("/investor")
//    public ResponseEntity<UserPayloadDto> signupNewInvestor(@RequestBody InvestorDto investorDto) {
//        if (userService.findByUsername(investorDto.getUsername()).isEmpty())
//            throw new ConflictException();
//
//        Investor registeredUser = userService.registerNewInvestor(investorDto);
//        return ResponseEntity.ok(UserPayloadDtoFactory.createUserDto(registeredUser));
//    }
//
//    @PostMapping("/curator")
//    public ResponseEntity<UserPayloadDto> signupNewCurator(@RequestBody CuratorDto curatorDto) {
//        if (userService.findByUsername(curatorDto.getUsername()).isPresent())
//            throw new ConflictException();
//
//        Curator registeredUser = userService.registerNewCurator(curatorDto);
//        return ResponseEntity.ok(UserPayloadDtoFactory.createUserDto(registeredUser));
//    }
}

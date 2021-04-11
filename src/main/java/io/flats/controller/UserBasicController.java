package io.flats.controller;

import io.flats.JWT_AUTH.dto.UserDto;
import io.flats.JWT_AUTH.jwt.JwtUser;
import io.flats.JWT_AUTH.jwt.JwtUserDetailsService;
import io.flats.JWT_AUTH.service.UserService;
import io.flats.dto.BasicResponce;
import io.flats.dto.ResponceCompletedDto;
import io.flats.dto.UserProfileImageUrlDto;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.repository.UserRepository;
import io.flats.service.FlatService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.AuthProvider;
import java.util.ArrayList;

/**
 * The type User basic controller.
 */
@Controller
@RequestMapping("/api/user")
public class UserBasicController {
    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * The User service.
     */
    @Autowired
    UserService userService;

    /**
     * The Authentication.
     */
    @Autowired
    JwtUserDetailsService authentication;

    @Autowired
    FlatService flatService;


    /**
     * Gets user profile image url by username.
     *
     * @param username the username
     * @return the user profile image url by username
     */
    @RequestMapping("get_user_img_url_by_username")
    public ResponseEntity<UserProfileImageUrlDto> getUserProfileImageUrlByUsername(@RequestParam String username) { //TODO: сменить id на токен
        System.out.println("d");

        //String url = "https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg";
        String url = userRepository.findByUsername(username).orElseThrow(
                () -> {throw new UserNotFoundExeption();}
        ).getUserProfileImageUrl();


        return ResponseEntity.ok(new UserProfileImageUrlDto(url));
    }

    /**
     * Gets user info.
     *
     * @param token the token
     * @return the user info
     */
    @RequestMapping("get_user_info_from_token")
    public ResponseEntity<User> getUserInfo(@RequestParam String token) {


        return null;
    }

    /**
     * Gets user posted flats.
     *
     * @return the user posted flats
     */
    @RequestMapping("get_user_posted_flats")
    public ResponseEntity<ArrayList<String>> getUserPostedFlats() {


        return null;
    }

    /**
     * Gets user info.
     *
     * @param userDto the user dto
     * @return the user info
     */
    @RequestMapping("get_user_info")
    public ResponseEntity<io.flats.dto.UserDto> getUserInfo(@RequestBody UserDto userDto) {
        User user = userService.findByUsername(userDto.getUsername()).get(); //TODO:

        io.flats.dto.UserDto userResponce = new io.flats.dto.UserDto();

        userResponce.setUsername(user.getUsername());
        userResponce.setEmail(user.getEmail());
        userResponce.setFirstName(user.getFirstName());
        userResponce.setLastName(user.getLastName());
        userResponce.setRole(user.getRole().getName());
        userResponce.setSecondName(user.getSecondName());
        userResponce.setPhoneNumber(user.getPhoneNumber());

        return ResponseEntity.ok(userResponce);
    }

    @PostMapping("set_like_to_flat")
    public ResponseEntity<BasicResponce> setLike(@RequestParam long id_to){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption();}
        );
        flatService.setLike(currentUser.getId(), id_to);
        return ResponseEntity.ok(new ResponceCompletedDto());
    }

    @PostMapping("set_comment_to_user")
    public ResponseEntity<BasicResponce> setComment(@RequestParam long id_to){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption();}
        );
        flatService.setLike(currentUser.getId(), id_to);
        return ResponseEntity.ok(new ResponceCompletedDto());
    }
}

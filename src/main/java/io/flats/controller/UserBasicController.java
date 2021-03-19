package io.flats.controller;

import io.flats.dto.UserProfileImageUrlDto;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

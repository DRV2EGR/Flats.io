package io.flats.controller;

import io.flats.dto.UserProfileImageUrlDto;
import io.flats.entity.User;
import io.flats.exception.UserNotFoundExeption;
import io.flats.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/user")
public class UserBasicController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("get_user_img_url_by_username")
    public ResponseEntity<UserProfileImageUrlDto> getUserProfileImageUrlByUsername(@RequestParam String username) { //TODO: сменить id на токен
        //String url = "https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg";
        String url = userRepository.findByUsername(username).orElseThrow(
                () -> {throw new UserNotFoundExeption();}
        ).getUserProfileImageUrl();


        return ResponseEntity.ok(new UserProfileImageUrlDto(url));
    }
}

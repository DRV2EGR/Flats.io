package io.flats.JWT_AUTH.config.controller;


import io.flats.JWT_AUTH.config.exeption.JwtInvalidRefreshTokenException;
import io.flats.JWT_AUTH.config.dto.AuthenticationRequestDto;
import io.flats.JWT_AUTH.config.dto.JwtAuthDto;
import io.flats.JWT_AUTH.config.jwt.JwtTokenProvider;
import io.flats.JWT_AUTH.config.service.UserService;
import io.flats.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthDto> login(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        try {
            User user = userService.findByUsername(authenticationRequestDto.getUsername()).orElseThrow(IllegalArgumentException::new);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));

            String accessToken = jwtTokenProvider.createAccessToken(user);
            String refreshToken = jwtTokenProvider.createRefreshToken(user.getId());

            JwtAuthDto jwtAuthDto = new JwtAuthDto();
            jwtAuthDto.setUsername(authenticationRequestDto.getUsername());
            jwtAuthDto.setAccessToken(accessToken);
            jwtAuthDto.setRefreshToken(refreshToken);

            return ResponseEntity.ok(jwtAuthDto);
        }
        catch (IllegalArgumentException e) {
            throw new JwtInvalidRefreshTokenException();
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthDto> refresh(@RequestBody JwtAuthDto tokenPairToRefresh) {
        JwtAuthDto jwtAuthDto = jwtTokenProvider.refreshPairOfTokens(tokenPairToRefresh.getRefreshToken());
        return ResponseEntity.ok(jwtAuthDto);
    }

//    @GetMapping("/activate/{activationCode}")
//    public ResponseEntity activateUser(@PathVariable String activationCode) {
//        userService.activateUser(activationCode);
//
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
}

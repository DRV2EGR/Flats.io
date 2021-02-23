package io.flats.JWT_AUTH.config.payload;

import io.flats.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDtoPayload {
    private String firstName;
    private String secondName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private String userProfileImageUrl;

    public UserDtoPayload(String firstName, String secondName, String lastName, String username, String email, String password, String phoneNumber, String role, String userProfileImageUrl) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.userProfileImageUrl = userProfileImageUrl;
    }
}

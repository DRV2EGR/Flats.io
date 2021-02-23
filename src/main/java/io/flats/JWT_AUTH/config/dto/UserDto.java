package io.flats.JWT_AUTH.config.dto;

import io.flats.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String secondName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;

    public UserDto(User user) {
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        role = user.getRole().getName();
    }
}

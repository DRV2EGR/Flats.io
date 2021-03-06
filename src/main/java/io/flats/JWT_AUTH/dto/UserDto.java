package io.flats.JWT_AUTH.dto;

import io.flats.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type User dto.
 */
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

    /**
     * Instantiates a new User dto.
     *
     * @param user the user
     */
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

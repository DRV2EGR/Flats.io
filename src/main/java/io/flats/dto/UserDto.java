package io.flats.dto;

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
    private String phoneNumber;
    private String role;

    /**
     * Instantiates a new User dto.
     *
     * @param firstName   the first name
     * @param secondName  the second name
     * @param lastName    the last name
     * @param username    the username
     * @param email       the email
     * @param phoneNumber the phone number
     * @param role        the role
     */
    public UserDto(String firstName, String secondName, String lastName, String username, String email, String phoneNumber, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
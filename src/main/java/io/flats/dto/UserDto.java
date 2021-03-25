package io.flats.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String secondName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String accountCreationTime;
    private String role;

    public UserDto(String firstName, String secondName, String lastName, String username, String email, String phoneNumber, String accountCreationTime, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accountCreationTime = accountCreationTime;
        this.role = role;
    }
}

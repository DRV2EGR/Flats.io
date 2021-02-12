package io.flats.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="users")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "second_name")
    protected String secondName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "username")
    protected String username;

    @Column(name = "email", nullable = false)
    protected String email;

    @Column(name = "password", nullable = false)
    protected String password;

    @Column(name = "phone_number")
    protected String phoneNumber;

    @Column(name = "activation_code")
    protected String activationCode;

    @Column(name = "time_of_account_creation")
    protected LocalDateTime timeOfAccountCreation;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    protected Role role;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}

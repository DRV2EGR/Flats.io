package io.flats.repository;

import io.flats.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<User> findByUsername(String username);

    /**
     * Find by activation code optional.
     *
     * @param encodedUserActivationCode the encoded user activation code
     * @return the optional
     */
    Optional<Object> findByActivationCode(String encodedUserActivationCode);

    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     */
    Optional<User> findByEmail(String email);
}

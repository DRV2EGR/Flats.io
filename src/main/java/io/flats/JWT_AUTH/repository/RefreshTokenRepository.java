package io.flats.JWT_AUTH.repository;

import io.flats.JWT_AUTH.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}

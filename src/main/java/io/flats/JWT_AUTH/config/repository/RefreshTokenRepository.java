package io.flats.JWT_AUTH.config.repository;

import io.flats.JWT_AUTH.config.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}

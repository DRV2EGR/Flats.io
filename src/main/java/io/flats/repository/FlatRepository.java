package io.flats.repository;

import java.util.List;

import io.flats.entity.Flat;
import io.flats.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Flat repository.
 */
public interface FlatRepository extends JpaRepository<Flat, Long> {
    List<Flat> findAllByOwner(User user);
}

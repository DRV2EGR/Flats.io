package io.flats.repository;

import io.flats.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepository extends JpaRepository<Flat, Long> {
}

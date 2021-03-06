package io.flats.repository;

import io.flats.entity.FlatOrderType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Flat order type repository.
 */
public interface FlatOrderTypeRepository extends JpaRepository<FlatOrderType, Long> {
}

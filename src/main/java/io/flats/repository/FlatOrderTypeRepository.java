package io.flats.repository;

import io.flats.entity.FlatOrderType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatOrderTypeRepository extends JpaRepository<FlatOrderType, Long> {
}

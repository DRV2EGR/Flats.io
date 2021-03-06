package io.flats.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * The type Base entity.
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(generator = "increment")
    protected long id;
}

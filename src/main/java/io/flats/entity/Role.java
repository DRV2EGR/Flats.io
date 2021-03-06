package io.flats.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The type Role.
 */
@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity {
    @Column
    private String name;
}

package io.flats.entity;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "increment")
    protected long id;
}
